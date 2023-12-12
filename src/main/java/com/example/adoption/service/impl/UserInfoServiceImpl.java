package com.example.adoption.service.impl;

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

		// �B�z �K�X�[�K�޿�
		// �p�Guser���K�X������ �h�[�K
		if (userInfo.getPassword() != null && !userInfo.getPassword().isEmpty()) {
			String encryptedPassword = encoder.encode(userInfo.getPassword());
			userInfo.setPassword(encryptedPassword); // �N�[�K�᪺�K�X�]�w�^UserInfo����
		}

		///// �B�zaccount�޿� �p�G�ϥΪ̨S���]�waccount �h�Q��mail@�e���r���account
		if (userInfo.getAccount() == null || userInfo.getAccount().isEmpty()) {
			String email = userInfo.getEmail();
			String[] emailParts = email.split("@");
			userInfo.setAccount(emailParts[0]); // �ϥ� @ ���e���r��@���b��
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

		// �䤣��b�� �n�J����
		if (userInfo == null) {
			return false;
		}
		// �K�X���~ �n�J����

		if (!encoder.matches(password, userInfo.getPassword())) {
			return false;
		}

		return true;
	}

}
