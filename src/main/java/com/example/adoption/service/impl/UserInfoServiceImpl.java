package com.example.adoption.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

import net.bytebuddy.utility.RandomString;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public UserInfoResponse create(UserInfoRequest req) {
		UserInfo userInfo = req.getUserInfo();

		// 處理 密碼加密邏輯
		// 如果user的密碼不為空 則加密
		if (userInfo.getPassword() != null && !userInfo.getPassword().isEmpty()) {
			String encryptedPassword = encoder.encode(userInfo.getPassword());
			userInfo.setPassword(encryptedPassword); // 將加密後的密碼設定回UserInfo物件中
		}

		///// 處理account邏輯 如果使用者沒有設定account 則利用mail@前的字串當成account
		if (userInfo.getAccount() == null || userInfo.getAccount().isEmpty()) {
			String email = userInfo.getEmail();
			String[] emailParts = email.split("@");
			userInfo.setAccount(emailParts[0]); // 使用 @ 之前的字串作為帳號
		}

		// 年齡處理
		LocalDate currentDate = LocalDate.now();
		LocalDate birth = userInfo.getBirthday();
		int age = Period.between(birth, currentDate).getYears();
		userInfo.setAge(age);

		// 12.14 permission for admin and user
		if ("iql2010317@gmail.com".equals(userInfo.getEmail())) {
			userInfo.setPermission(20); // for admin
		} else {
			userInfo.setPermission(5); // forn user
		}

		String randomSting = RandomString.make(6);
		LocalDateTime currentTime = LocalDateTime.now();
		userInfo.setHasOpened(false); // 預設為未開通帳號
		userInfo.setRandomStringTime(currentTime); // 設定當前時間
		userInfo.setRegisterRandomString(randomSting); // 隨機代碼

		//// 寄送信件邏輯
		// 寄送信件邏輯
		String recipientEmail = userInfo.getEmail();
		String randomString = userInfo.getRegisterRandomString(); // 從 UserInfo 中取得隨機

		// 設定SMTP
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // 以 Gmail 為例
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 指定協議

		// 創建 Session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("iql2010317@gmail.com", "lolv jfyz oysi aqnk");
			}
		});

		try {
			// 設定 MimeMessage
			Message message = new MimeMessage(session);

			// 設定寄件人
			message.setFrom(new InternetAddress("iql2010317@gmail.com", "玉翔"));

			// 設定收件人
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

			// 設定信件主題
			message.setSubject("寵物會員認證碼");

			// 設定信件內容
			message.setText("使用此代碼作為註冊認證碼" + randomString);

			// 發送信件
			Transport.send(message);

			System.out.println("發送成功!!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("發送失敗!!!");
		}

		UserInfo saveduserInfo = userInfoDao.save(userInfo);
		return new UserInfoResponse(saveduserInfo);
	}

	@Override
	public UserInfoResponse compareAuthenticationCode(UserInfoRequest req) {

		UserInfo userInfo = userInfoDao.findByEmail(req.getUserInfo().getEmail());

		// 取得用戶傳來的 Email 和驗證碼
		String email = userInfo.getEmail();
		String authenticationCode = userInfo.getRegisterRandomString();

		// 在資料庫中查找相應的用戶
		UserInfo storedUserInfo = userInfoDao.findByEmail(email);

		if (storedUserInfo == null) {
			// 如果找不到相應的用戶，返回錯誤訊息或適當的提示
			return new UserInfoResponse(storedUserInfo);
		} else {
			// 找到用戶，檢查驗證碼是否匹配
			String storedAuthenticationCode = storedUserInfo.getRegisterRandomString();

			if (authenticationCode.equals(storedAuthenticationCode)) {
				// 驗證碼匹配，將帳號設為已開通，清空隨機驗證碼和時間戳
				storedUserInfo.setHasOpened(true);
				storedUserInfo.setRandomStringTime(null);
				storedUserInfo.setRegisterRandomString(null);
				userInfoDao.save(storedUserInfo); // 更新用戶資訊

				// 返回更新後的用戶資訊
				return new UserInfoResponse(storedUserInfo);
			} else {
				// 驗證碼不匹配，返回錯誤訊息或適當的提示
				return new UserInfoResponse(storedUserInfo);
			}
		}

	}

	@Override
	public UserInfoResponse search() {
		return new UserInfoResponse(userInfoDao.findAll());
	}

	@Override
	public String userLogin(String email, String password) {
		UserInfo userInfo = userInfoDao.findByEmail(email);

		// 找不到帳號 登入失敗
		if (userInfo == null) {
			return "找不到信箱";
		}

		// 帳號未開通，需要輸入隨機碼
		if (!userInfo.isHasOpened()) {
			// 檢查是否有隨機碼時間戳
			LocalDateTime randomStringTime = userInfo.getRandomStringTime();
			if (randomStringTime != null) {
				LocalDateTime currentTime = LocalDateTime.now();
				Duration duration = Duration.between(randomStringTime, currentTime);
				long minutesPassed = duration.toMinutes();

				//設定認證時間
				if (minutesPassed <= 30 && password.equals(userInfo.getRegisterRandomString())) {
					// 登入成功並開通帳號
					userInfo.setHasOpened(true);
					userInfo.setRandomStringTime(null);
					userInfo.setRegisterRandomString(null);

					// 將更新後的 userInfo 物件保存到資料庫
					userInfoDao.save(userInfo);

					return "成功登入";
				} else {
					// 登入失敗，隨機碼錯誤或過期
					return "隨機碼錯誤或已過期，開通失敗";
				}
			} else {
				// 登入失敗，無隨機碼時間戳
				return "無隨機碼時間戳，開通失敗";
			}
		}

		// 密碼錯誤 登入失敗
		if (!encoder.matches(password, userInfo.getPassword())) {
			return "密碼錯誤，登入失敗";
		}

		// 正常登入
		return "成功登入";
	}

	@Override
	public UserInfoResponse update(UserInfoRequest req) {
		
		//從UserInfoRequest 來的 userInfo
		UserInfo userInfo = req.getUserInfo();
		
		Optional<UserInfo> existingUserInfoOptional = userInfoDao.findById(userInfo.getUserId());

		if (existingUserInfoOptional.isPresent()) {
			
			//透過findById 得到的existingUserInfo
			UserInfo existingUserInfo = existingUserInfoOptional.get();

			//若更新資訊不為空 則讓userInfo set為 existingUserInfo 
			if (userInfo.getUserName() != null) {
				existingUserInfo.setUserName(userInfo.getUserName());
			}

			if (userInfo.getAccount() != null) {
				existingUserInfo.setAccount(userInfo.getAccount());
			}

			if (userInfo.getAddress() != null) {
				existingUserInfo.setAddress(userInfo.getAddress());
			}
			if (userInfo.getAge() > 0) {
				existingUserInfo.setAge(userInfo.getAge());
			}
			if (userInfo.getBirthday() != null) {
				existingUserInfo.setBirthday(userInfo.getBirthday());
			}

			if (userInfo.getEmail() != null) {
				existingUserInfo.setEmail(userInfo.getEmail());
			}

			if (userInfo.getFamilyStatus() != null) {
				existingUserInfo.setFamilyStatus(userInfo.getFamilyStatus());
			}

			if (userInfo.getGender() != null) {
				existingUserInfo.setGender(userInfo.getGender());
			}
			if (userInfo.getJobOccupation() != null) {
				existingUserInfo.setJobOccupation(userInfo.getJobOccupation());
			}

			if (userInfo.getPhone() != null) {
				existingUserInfo.setPhone(userInfo.getPhone());
			}

			if (userInfo.getProfile() != null) {
				existingUserInfo.setProfile(userInfo.getProfile());
			}
			if (userInfo.getSentenceToAdopter() != null) {
				existingUserInfo.setSentenceToAdopter(userInfo.getSentenceToAdopter());
			}

			if (userInfo.getUserRealName() != null) {
				existingUserInfo.setUserRealName(userInfo.getUserRealName());
			}

			if (userInfo.getPermission() > 0) {
				existingUserInfo.setPermission(userInfo.getPermission());
			}

			if (userInfo.getUserPhoto() != null) {
				existingUserInfo.setUserPhoto(userInfo.getUserPhoto());
			}

			// 儲存更新後的資料
			UserInfo savedUserInfo = userInfoDao.save(existingUserInfo);
			return new UserInfoResponse(savedUserInfo);
		} else {
			
			return new UserInfoResponse(); 
		}
	}

	// 檢查密碼是否有更改的輔助方法 //先保留
	private boolean isPasswordChanged(UserInfo newUserInfo, UserInfo originalUserInfo) {
		// 檢查密碼是否相同
		return newUserInfo.getPassword() != null && !newUserInfo.getPassword().isEmpty()
				&& !encoder.matches(newUserInfo.getPassword(), originalUserInfo.getPassword());

	}

	@Override
	public String userFogetPassword(String email) {
		UserInfo userInfo = userInfoDao.findByEmail(email);

		// 找不到帳號 登入失敗
		if (userInfo == null) {
			return "找不到信箱";
		}

		String randomSting = RandomString.make(6);
		LocalDateTime currentTime = LocalDateTime.now();
		userInfo.setHasOpened(false); // 預設為未開通帳號
		userInfo.setRandomStringTime(currentTime); // 設定當前時間
		userInfo.setRegisterRandomString(randomSting); // 隨機代碼

		// 將更新後的 userInfo 物件保存到資料庫
		userInfoDao.save(userInfo);

		//// 寄送信件邏輯
		// 寄送信件邏輯
		String recipientEmail = userInfo.getEmail();
		String randomString = userInfo.getRegisterRandomString(); // 從 UserInfo 中取得隨機認證碼

		// 設定SMTP
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // 以 Gmail 為例
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 指定協議

		// 創建 Session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("iql2010317@gmail.com", "lolv jfyz oysi aqnk");
			}
		});

		try {
			// 設定 MimeMessage
			Message message = new MimeMessage(session);

			// 設定寄件人
			message.setFrom(new InternetAddress("iql2010317@gmail.com", "玉翔"));

			// 設定收件人
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

			// 設定信件主題 
			message.setSubject("寵物會員認證碼");

			// 設定信件內容 //信件內容 for userFogetPassword
			message.setText("使用此代碼作為臨時登入密碼" + randomString);

			// 發送信件
			Transport.send(message);

			System.out.println("發送成功!!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("發送失敗!!!");
		}

		return "已發送認證碼至信箱";
	}

	@Override
	public String sendAuthenticationCode(String email) {

		UserInfo userInfo = userInfoDao.findByEmail(email);

		// 找不到帳號 登入失敗
		if (userInfo == null) {
			return "找不到信箱";
		}

		String randomSting = RandomString.make(6);
		LocalDateTime currentTime = LocalDateTime.now();
		userInfo.setHasOpened(false); // 預設為未開通帳號
		userInfo.setRandomStringTime(currentTime); // 設定當前時間
		userInfo.setRegisterRandomString(randomSting); // 隨機代碼

		// 將更新後的 userInfo 物件保存到資料庫
		userInfoDao.save(userInfo);

		//// 寄送信件邏輯
		// 寄送信件邏輯
		String recipientEmail = userInfo.getEmail();
		String randomString = userInfo.getRegisterRandomString(); // 從 UserInfo 中取得隨機

		// 設定SMTP
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // 以 Gmail 為例
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 指定協議

		// 創建 Session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("iql2010317@gmail.com", "lolv jfyz oysi aqnk");
			}
		});

		try {
			// 設定 MimeMessage
			Message message = new MimeMessage(session);

			// 設定寄件人
			message.setFrom(new InternetAddress("iql2010317@gmail.com", "玉翔"));

			// 設定收件人
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

			// 設定信件主題
			message.setSubject("寵物會員認證碼");

			// 設定信件內容
			message.setText("使用此代碼作為第一次登入密碼" + randomString);

			// 發送信件
			Transport.send(message);

			System.out.println("發送成功!!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("發送失敗!!!");
		}

		return "已發送認證碼至信箱";

	}

	@Override
	public String forceChangePassword(String email, String newPassword, String confirmPassword) {

		UserInfo userInfo = userInfoDao.findByEmail(email);

		// 找不到帳號 登入失敗
		if (userInfo == null) {
			return "找不到信箱";
		}

		// 比較新密碼和確認密碼是否相符
		if (!newPassword.equals(confirmPassword)) {
			return "輸入密碼不相符";
		}

		// 重設用戶密碼
		if (newPassword != null && !newPassword.isEmpty()) {
			String encryptedPassword = encoder.encode(newPassword);
			userInfo.setPassword(encryptedPassword); // 將加密後的新密碼設定回UserInfo物件中
		}

		// 將更新後的 userInfo 物件保存到資料庫
		userInfoDao.save(userInfo);

		return "成功更新密碼，請重新登入";
	}

	@Override
	public UserInfoResponse searchById(int userId) {
		UserInfo userInfo = userInfoDao.findByUserId(userId);
		return new UserInfoResponse(userInfo);
	}

	@Override
	public UserInfoResponse createFakeUser(UserInfoRequest req) {
		UserInfo userInfo = req.getUserInfo();

		// 處理 密碼加密邏輯
		// 如果user的密碼不為空 則加密
		if (userInfo.getPassword() != null && !userInfo.getPassword().isEmpty()) {
			String encryptedPassword = encoder.encode(userInfo.getPassword());
			userInfo.setPassword(encryptedPassword); // 將加密後的密碼設定回UserInfo物件中
		}

		///// 處理account邏輯 如果使用者沒有設定account 則利用mail@前的字串當成account
		if (userInfo.getAccount() == null || userInfo.getAccount().isEmpty()) {
			String email = userInfo.getEmail();
			String[] emailParts = email.split("@");
			userInfo.setAccount(emailParts[0]); // 使用 @ 之前的字串作為帳號
		}

		userInfo.setHasOpened(true);
		userInfo.setPermission(5);

		// age
		LocalDate currentDate = LocalDate.now();
		LocalDate birth = userInfo.getBirthday();
		int age = Period.between(birth, currentDate).getYears();
		userInfo.setAge(age);

		UserInfo saveduserInfo = userInfoDao.save(userInfo);
		return new UserInfoResponse(saveduserInfo);
	}

}
