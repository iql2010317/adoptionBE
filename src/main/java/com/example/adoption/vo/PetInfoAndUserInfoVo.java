package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.PetInfo;
import com.example.adoption.entity.UserInfo;

public class PetInfoAndUserInfoVo {

	
	/* parameters */
	private PetInfo petInfo;
	
	private UserInfo userInfo;
	
	private List<PetInfo> petInfoList;

	
	
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
	
	
	public PetInfoAndUserInfoVo(UserInfo userInfo, List<PetInfo> petInfoList) {
		super();
		this.userInfo = userInfo;
		this.petInfoList = petInfoList;
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

	public List<PetInfo> getPetInfoList() {
		return petInfoList;
	}

	public void setPetInfoList(List<PetInfo> petInfoList) {
		this.petInfoList = petInfoList;
	}
	
	
	
}
