package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PetInfo;

public class PetInfoListResponse {

	
	private List<PetInfo> petInfoList;
	
	private RtnCode rtnCode;

	public PetInfoListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetInfoListResponse(List<PetInfo> petInfoList, RtnCode rtnCode) {
		super();
		this.petInfoList = petInfoList;
		this.rtnCode = rtnCode;
	}

	public List<PetInfo> getPetInfoList() {
		return petInfoList;
	}

	public void setPetInfoList(List<PetInfo> petInfoList) {
		this.petInfoList = petInfoList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
}
