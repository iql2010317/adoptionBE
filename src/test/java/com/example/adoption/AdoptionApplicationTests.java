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

	// �s�W�H�����
	@Test
	void userInfoCreateTest() {
		UserInfo userInfo = new UserInfo();
//		userInfo.setUserName("test");
//		userInfo.setPassword("test");
//		userInfo.setPhone("0977456874");
//		userInfo.setEmail("test@gamil.com");
		LocalDate birth = LocalDate.parse("1995-03-13");
//		userInfo.setAccount("haha");
		userInfo.setPassword("123");
		userInfo.setEmail("test99");
		userInfo.setBirthday(birth);

		UserInfoRequest req = new UserInfoRequest(userInfo);
		userInfoService.create(req);
	}

	@Test
	void userInfoUpdateTest() {
		// �����w�s�b���Ʈw���� UserInfo
		int userIdToUpdate = 13; // ���]�ݭn��s���Τ�ID��1
		UserInfo existingUserInfo = userInfoDao.findById(userIdToUpdate).orElse(null);

		// ���]�b��Ʈw�����F�ӥΤ�H��
		assertNotNull(existingUserInfo);

		// ��s�ӨϥΪ̪����
		existingUserInfo.setUserName("��"); // ��s�Τ�W��

		// �Ыؤ@�� UserInfoRequest ����
		UserInfoRequest req = new UserInfoRequest(existingUserInfo);

		// �I�s update ��k�i���s
		UserInfoResponse response = userInfoService.update(req);

		// �T�{��s�᪺�^���O�_���\
		assertNotNull(response);
		assertEquals(existingUserInfo.getUserName(), response.getUserInfo().getUserName());
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
