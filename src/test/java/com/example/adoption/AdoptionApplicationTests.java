package com.example.adoption;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.UserInfo;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

@SpringBootTest
class AdoptionApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	// �s�W�H�����
	@Test
	void userInfoCreateTest() {
		UserInfo userInfo = new UserInfo();
//		userInfo.setUserName("test");
//		userInfo.setPassword("test");
//		userInfo.setPhone("0977456874");
//		userInfo.setEmail("test@gamil.com");
		LocalDate birth = LocalDate.parse("1998-05-05");
		userInfo.setAccount("�g�ɪ��Q�D");
		userInfo.setPassword("0505");
		userInfo.setEmail("popo0505@gamil.com");
		userInfo.setBirthday(birth);

		UserInfoRequest req = new UserInfoRequest(userInfo);
		userInfoService.create(req);
	}

	// �M��H����ƲM��
	@Test
	void userInfoSearchTest() {
		UserInfoResponse res = userInfoService.search();
		List<UserInfo> userInfoList = res.getUserInfoList();
		for (UserInfo userInfo : userInfoList) {
			System.out.println("�H���W��:" + userInfo.getUserName());
			System.out.println("�q�l�l��:" + userInfo.getEmail());
			System.out.println("������X:" + userInfo.getPhone());
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
