package com.example.adoption.vo;

public class PetAdoptionRequest extends PetIdAndOwnerIdAndAdopterIdVo{
	
	private int adopterRes;

	public PetAdoptionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetAdoptionRequest(String petId, int ownerId, int adopterId) {
		super(petId, ownerId, adopterId);
		// TODO Auto-generated constructor stub
	}

	public PetAdoptionRequest(String petId, int ownerId, int adopterId, int adopterRes) {
		super(petId, ownerId, adopterId);
		this.adopterRes = adopterRes;
	}

	public int getAdopterRes() {
		return adopterRes;
	}

	public void setAdopterRes(int adopterRes) {
		this.adopterRes = adopterRes;
	}

	
	
}
