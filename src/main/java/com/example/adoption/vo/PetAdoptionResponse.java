package com.example.adoption.vo;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PetAdoption;

public class PetAdoptionResponse {

	private PetAdoption petAdoption;
	
	private RtnCode rtnCode;

	public PetAdoptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetAdoptionResponse(PetAdoption petAdoption, RtnCode rtnCode) {
		super();
		this.petAdoption = petAdoption;
		this.rtnCode = rtnCode;
	}

	public PetAdoption getPetAdoption() {
		return petAdoption;
	}

	public void setPetAdoption(PetAdoption petAdoption) {
		this.petAdoption = petAdoption;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
	
}
