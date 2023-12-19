package com.example.adoption.vo;

public class PetIdAndUserIdVo {

	
	
	/* parameters */
	private String petId;
	
	
	private int userId;

	
	
	
	/* constructors */
	public PetIdAndUserIdVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PetIdAndUserIdVo(String petId, int userId) {
		super();
		this.petId = petId;
		this.userId = userId;
	}

	
	
	
	/* getter&setter */
	public String getPetId() {
		return petId;
	}


	public void setPetId(String petId) {
		this.petId = petId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
