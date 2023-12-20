package com.example.adoption.vo;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PetInfo;

public class PetInfoResponse {
	
	
	
	/* parameters */
	private PetInfo petInfo;

	private RtnCode rtnCode;

	
	
	/* constructors */
	public PetInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetInfoResponse(PetInfo petInfo, RtnCode rtnCode) {
		super();
		this.petInfo = petInfo;
		this.rtnCode = rtnCode;
	}
	
	
	
	/* getter&setter*/

	public PetInfo getPetInfo() {
		return petInfo;
	}

	public void setPetInfo(PetInfo petInfo) {
		this.petInfo = petInfo;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	
	
}
