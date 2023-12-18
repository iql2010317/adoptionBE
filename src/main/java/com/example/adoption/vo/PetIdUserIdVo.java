package com.example.adoption.vo;

public class PetIdUserIdVo {

	
	
	/* parameters */
	private String petId;
	
	
	private int userId;

	
	
	
	/* constructors */
	public PetIdUserIdVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PetIdUserIdVo(String petId, int userId) {
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
