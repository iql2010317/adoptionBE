package com.example.adoption.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "pet_info")
public class PetInfo {
	
	
	/* parameters */
	@Id
	@Column(name = "pet_id")
	private String petId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "pet_name")
	private String petName; 

	@Column(name = "adopter_id_list")
	private String adopterIdList;

	@Column(name = "final_adopter_id")
	private int finalAdopterId; 

	@Column(name = "pet_breed")
	private String petBreed;

	@Column(name = "pet_status")
	private String petStatus;

	@Column(name = "adoption_status")
	private String adoptionStatus;

	@Column(name = "adoption_conditions")
	private String adoptionConditions;

	@Column(name = "age")
	private String age;

	@Column(name = "vaccine")
	private String vaccine;

	@Column(name = "pet_profile")
	private String petProfile;

	@Column(name = "ligation")
	private boolean ligation;

	@Column(name = "type")
	private String type;

	@Column(name = "pet_photo")
	private String petPhoto;

	@Column(name = "pet_other_photo")
	private String petOtherPhoto;
	
	@Column(name = "location")
	private String locaiton;

	public PetInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PetInfo(int userId, String petName, String petBreed, String petStatus, String adoptionStatus, String age,
			String vaccine, String petProfile, boolean ligation, String type, String petPhoto, String locaiton) {
		super();
		this.userId = userId;
		this.petName = petName;
		this.petBreed = petBreed;
		this.petStatus = petStatus;
		this.adoptionStatus = adoptionStatus;
		this.age = age;
		this.vaccine = vaccine;
		this.petProfile = petProfile;
		this.ligation = ligation;
		this.type = type;
		this.petPhoto = petPhoto;
		this.locaiton = locaiton;
	}



	public PetInfo(int userId, String petName, String adoptionStatus, String type) {
		super();
		this.userId = userId;
		this.petName = petName;
		this.adoptionStatus = adoptionStatus;
		this.type = type;
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

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getAdopterIdList() {
		return adopterIdList;
	}

	public void setAdopterIdList(String adopterIdList) {
		this.adopterIdList = adopterIdList;
	}

	public int getFinalAdopterId() {
		return finalAdopterId;
	}

	public void setFinalAdopterId(int finalAdopterId) {
		this.finalAdopterId = finalAdopterId;
	}

	public String getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}

	public String getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(String petStatus) {
		this.petStatus = petStatus;
	}

	public String getAdoptionStatus() {
		return adoptionStatus;
	}

	public void setAdoptionStatus(String adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
	}

	public String getAdoptionConditions() {
		return adoptionConditions;
	}

	public void setAdoptionConditions(String adoptionConditions) {
		this.adoptionConditions = adoptionConditions;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String getPetProfile() {
		return petProfile;
	}

	public void setPetProfile(String petProfile) {
		this.petProfile = petProfile;
	}

	public boolean isLigation() {
		return ligation;
	}

	public void setLigation(boolean ligation) {
		this.ligation = ligation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPetPhoto() {
		return petPhoto;
	}

	public void setPetPhoto(String petPhoto) {
		this.petPhoto = petPhoto;
	}

	public String getPetOtherPhoto() {
		return petOtherPhoto;
	}

	public void setPetOtherPhoto(String petOtherPhoto) {
		this.petOtherPhoto = petOtherPhoto;
	}

	public String getLocaiton() {
		return locaiton;
	}

	public void setLocaiton(String locaiton) {
		this.locaiton = locaiton;
	}
	
	
}
