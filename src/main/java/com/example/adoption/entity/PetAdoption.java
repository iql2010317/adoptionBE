package com.example.adoption.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_adoption")
public class PetAdoption {

	
	/* parameters */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@JsonProperty("serial_no")
	@Column(name = "serial_no")
	private int serialNo;

	@JsonProperty("pet_id")
	@Column(name = "pet_id")
	private String petId;
	
	@JsonProperty("owner_id")
	@Column(name = "owner_id")
	private int ownerId;

	@JsonProperty("adopter_id")
	@Column(name = "adopter_id")
	private int adopterId; 

	@JsonProperty("owner_confirm")
	@Column(name = "owner_confirm")
	private int ownerConfirm = 1;

	@JsonProperty("adopter_confirm")
	@Column(name = "adopter_confirm")
	private int adopterConfirm = 0;

	
	
	/* constructors */
	public PetAdoption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetAdoption(String petId, int ownerId, int adopterId, int ownerConfirm, int adopterConfirm) {
		super();
		this.petId = petId;
		this.ownerId = ownerId;
		this.adopterId = adopterId;
		this.ownerConfirm = ownerConfirm;
		this.adopterConfirm = adopterConfirm;
	}
	

	/* getter&setter */
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

	public int getOwnerConfirm() {
		return ownerConfirm;
	}

	public void setOwnerConfirm(int ownerConfirm) {
		this.ownerConfirm = ownerConfirm;
	}

	public int getAdopterConfirm() {
		return adopterConfirm;
	}

	public void setAdopterConfirm(int adopterConfirm) {
		this.adopterConfirm = adopterConfirm;
	}

	public int getSerialNo() {
		return serialNo;
	}

	
	
	
	
}
