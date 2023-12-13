package com.example.adoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

@SpringBootTest
class AdoptionApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserInfoDao userInfoDao;

	// 新增人員資料
	@Test
	void userInfoCreateTest() {
		UserInfo userInfo = new UserInfo();
//		userInfo.setUserName("test");
//		userInfo.setPassword("test");
//		userInfo.setPhone("0977456874");
//		userInfo.setEmail("test@gamil.com");
		LocalDate birth = LocalDate.parse("2001-05-05");
//		userInfo.setAccount("haha");
		userInfo.setPassword("test01");
		userInfo.setEmail("test01@mail.com");
		userInfo.setBirthday(birth);

		UserInfoRequest req = new UserInfoRequest(userInfo);
		userInfoService.create(req);
	}

	@Test
	void userInfoUpdateTest() {
		// 模擬已存在於資料庫中的 UserInfo
		int userIdToUpdate = 4; // 假設需要更新的用戶ID為1
		UserInfo existingUserInfo = userInfoDao.findById(userIdToUpdate).orElse(null);

		// 假設在資料庫中找到了該用戶信息
		assertNotNull(existingUserInfo);

		// 更新該使用者的資料
		existingUserInfo.setUserName("Updated Name3"); // 更新用戶名稱

		// 創建一個 UserInfoRequest 物件
		UserInfoRequest req = new UserInfoRequest(existingUserInfo);

		// 呼叫 update 方法進行更新
		UserInfoResponse response = userInfoService.update(req);

		// 確認更新後的回應是否成功
		assertNotNull(response);
		assertEquals(existingUserInfo.getUserName(), response.getUserInfo().getUserName());
	}

	// 尋找人員資料清單
	@Test
	void userInfoSearchTest() {
		UserInfoResponse res = userInfoService.search();
		List<UserInfo> userInfoList = res.getUserInfoList();
		for (UserInfo userInfo : userInfoList) {
			System.out.println("人員名稱:" + userInfo.getUserName());
			System.out.println("電子郵件:" + userInfo.getEmail());
			System.out.println("手機號碼:" + userInfo.getPhone());
		}
	}

	@Test
	void userInfoLoginTest() {

		String validAccount = "danly0631";
		String validPassword = "danly123";

		boolean loginResult = userInfoService.userLogin(validAccount, validPassword);

		System.out.println(loginResult);
	}

}
