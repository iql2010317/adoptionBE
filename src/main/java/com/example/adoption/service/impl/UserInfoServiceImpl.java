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

}
