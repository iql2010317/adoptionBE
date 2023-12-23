package com.example.adoption.vo;

public class PetIdAndOwnerIdAndAdopterIdVo {

	
	private String petId;
	
	private int ownerId;
	
	private int adopterId;

	public PetIdAndOwnerIdAndAdopterIdVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetIdAndOwnerIdAndAdopterIdVo(String petId, int ownerId, int adopterId) {
		super();
		this.petId = petId;
		this.ownerId = ownerId;
		this.adopterId = adopterId;
	}

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getAdopterId() {
		return adopterId;
	}

	public void setAdopterId(int adopterId) {
		this.adopterId = adopterId;
	}
	
	
	
}
