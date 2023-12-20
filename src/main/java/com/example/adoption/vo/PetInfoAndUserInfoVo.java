package com.example.adoption.vo;

import com.example.adoption.entity.PetInfo;
import com.example.adoption.entity.UserInfo;

public class PetInfoAndUserInfoVo {

	
	/* parameters */
	private PetInfo petInfo;
	
	private UserInfo userInfo;

	
	
	/* constructors */
	public PetInfoAndUserInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetInfoAndUserInfoVo(PetInfo petInfo, UserInfo userInfo) {
		super();
		this.petInfo = petInfo;
		this.userInfo = userInfo;
	}

	
	/* getter&setter */
	public PetInfo getPetInfo() {
		return petInfo;
	}

	public void setPetInfo(PetInfo petInfo) {
		this.petInfo = petInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
}
