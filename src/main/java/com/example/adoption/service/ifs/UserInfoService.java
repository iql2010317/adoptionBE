package com.example.adoption.service.ifs;

import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

public interface UserInfoService {

	// 人員註冊
	public UserInfoResponse create(UserInfoRequest req);

	// 比對驗證碼邏輯
	public UserInfoResponse compareAuthenticationCode(UserInfoRequest req);

	// 尋找人員資料
	public UserInfoResponse search();

	// for pet search user
	public UserInfoResponse searchById(int userId);

	// 用戶註冊
	public String userLogin(String email, String password);

	// 用戶資料更新
	public UserInfoResponse update(UserInfoRequest req);

	// 用戶忘記密碼
	public String userFogetPassword(String email);

	// 發送認證信
	public String sendAuthenticationCode(String email);

	// 強制修改密碼
	public String forceChangePassword(String email, String newPassword, String confirmPassword);

	public UserInfoResponse createFakeUser(UserInfoRequest req);

}
