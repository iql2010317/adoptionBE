package com.example.adoption.service.ifs;

import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

public interface UserInfoService {

	public UserInfoResponse create(UserInfoRequest req);

	public UserInfoResponse search();

	public boolean userLogin(String account, String password);

	public UserInfoResponse update(UserInfoRequest req);

}
