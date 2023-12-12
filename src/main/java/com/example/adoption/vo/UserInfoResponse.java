package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.UserInfo;

public class UserInfoResponse {

	private UserInfo userInfo;

	private List<UserInfo> userInfoList;

	public UserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoResponse(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	public UserInfoResponse(List<UserInfo> userInfoList) {
		super();
		this.userInfoList = userInfoList;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

}
