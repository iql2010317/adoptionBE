package com.example.adoption.service.ifs;

import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

public interface UserInfoService {

	// 註冊邏輯 (for user or admin
	public UserInfoResponse create(UserInfoRequest req);

	// 註冊邏輯 +加入比對認證碼
	public UserInfoResponse compareAuthenticationCode(UserInfoRequest req);

	// 全體人員列表搜尋 (for admin
	public UserInfoResponse search();

	// 登入邏輯 (for user or admin
	public String userLogin(String email, String password);

	// 更新邏輯 (for user or admin
	public UserInfoResponse update(UserInfoRequest req);

	// 用戶 忘記密碼
	public String userFogetPassword(String email);

	// 註冊用戶 發送認證碼
	public String sendAuthenticationCode(String email);

	// 已註冊用戶 忘記密碼 
	//使用6位隨機碼登入後 強制更改密碼
	public String forceChangePassword(String email, String newPassword, String confirmPassword);

}
