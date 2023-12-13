package com.example.adoption.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

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

		UserInfo saveduserInfo = userInfoDao.save(userInfo);
		return new UserInfoResponse(saveduserInfo);
	}

	@Override
	public UserInfoResponse search() {
		return new UserInfoResponse(userInfoDao.findAll());
	}

	@Override
	public boolean userLogin(String account, String password) {
		UserInfo userInfo = userInfoDao.findByAccount(account);

		// 找不到帳號 登入失敗
		if (userInfo == null) {
			return false;
		}
		// 密碼錯誤 登入失敗

		if (!encoder.matches(password, userInfo.getPassword())) {
			return false;
		}

		return true;
	}

	@Override
	public UserInfoResponse update(UserInfoRequest req) {
		UserInfo userInfo = req.getUserInfo();

		Optional<UserInfo> existingUserInfoOptional = userInfoDao.findById(userInfo.getUserId());

		if (existingUserInfoOptional.isPresent()) {
			UserInfo existingUserInfo = existingUserInfoOptional.get();

			////
			if (userInfo.getUserName() != null) {
				existingUserInfo.setUserName(userInfo.getUserName());
			}

			///
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

			///
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

			String base64Photo = userInfo.getUserPhoto();

			if (base64Photo != null && !base64Photo.isEmpty()) {
				// 找到逗號的位置
				int commaIndex = base64Photo.indexOf(',');
				if (commaIndex != -1) {
					// 截取逗號後的部分
					String base64Image = base64Photo.substring(commaIndex + 1);

					try {
						byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

						String timestamp = String.valueOf(System.currentTimeMillis());
						String imageName = "image_" + timestamp + ".jpg";
						String imagePath = "C:/Users/iql20/OneDrive/桌面/htmlfile/2023-12-25/public/" + imageName;

						FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
						fileOutputStream.write(decodedBytes);
						fileOutputStream.close();

						// 將檔案路徑設置到 userInfo 中
						existingUserInfo.setUserPhoto(imagePath);
					} catch (IOException e) {
						// 處理例外
						e.printStackTrace();
					}
				}
			}

			// 儲存更新後的資料
			UserInfo savedUserInfo = userInfoDao.save(existingUserInfo);
			return new UserInfoResponse(savedUserInfo);
		} else {
			// 找不到要更新的資料
			return new UserInfoResponse(); // 或者適當的錯誤處理
		}
	}

//	@Override
//	public UserInfoResponse update(UserInfoRequest req) {
//		UserInfo userInfo = req.getUserInfo();
//
//
//		String base64Photo = userInfo.getUserPhoto();
//		if (base64Photo != null && !base64Photo.isEmpty()) {
//			// 找到逗號的位置
//			int commaIndex = base64Photo.indexOf(',');
//			if (commaIndex != -1) {
//				// 截取逗號後的部分
//				String base64Image = base64Photo.substring(commaIndex + 1);
//
//				try {
//					byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
//
//					String timestamp = String.valueOf(System.currentTimeMillis());
//					String imageName = "image_" + timestamp + ".jpg";
//					String imagePath = "C:/Users/iql20/OneDrive/桌面/pic/" + imageName;
//
//					FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
//					fileOutputStream.write(decodedBytes);
//					fileOutputStream.close();
//
//					// 將檔案路徑設置到 userInfo 中
//					userInfo.setUserPhoto(imagePath);
//				} catch (IOException e) {
//					// 處理例外
//					e.printStackTrace();
//				}
//			}
//		}
//
//		UserInfo saveduserInfo = userInfoDao.save(userInfo);
//		return new UserInfoResponse(saveduserInfo);
//	}

	// 檢查密碼是否有更改的輔助方法
	private boolean isPasswordChanged(UserInfo newUserInfo, UserInfo originalUserInfo) {
		// 檢查密碼是否相同
		return newUserInfo.getPassword() != null && !newUserInfo.getPassword().isEmpty()
				&& !encoder.matches(newUserInfo.getPassword(), originalUserInfo.getPassword());

	}
}
