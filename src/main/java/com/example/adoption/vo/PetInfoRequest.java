package com.example.adoption.vo;

import com.example.adoption.entity.PetInfo;

public class PetInfoRequest extends PetInfo{
	
	private PetInfo petInfo;

	public PetInfoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetInfoRequest(int userId, String petName, String adoptionStatus, String type) {
		super(userId, petName, adoptionStatus, type);
		// TODO Auto-generated constructor stub
	}

	public PetInfoRequest(PetInfo petInfo) {
		super();
		this.petInfo = petInfo;
	}

	public PetInfo getPetInfo() {
		return petInfo;
	}

	public void setPetInfo(PetInfo petInfo) {
		this.petInfo = petInfo;
	}

	
	
}
