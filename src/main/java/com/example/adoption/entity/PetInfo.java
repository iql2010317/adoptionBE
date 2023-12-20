package com.example.adoption.entity;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_info")
public class PetInfo {

	/* parameters */
	@Id
	@JsonProperty("pet_id")
	@Column(name = "pet_id")
	private String petId;

	@JsonProperty("user_id")
	@Column(name = "user_id")
	private int userId;

	@JsonProperty("pet_name")
	@Column(name = "pet_name")
	private String petName;

	@JsonProperty("adopter_id_list")
	@Column(name = "adopter_id_list")
	private String adopterIdList;

	@JsonProperty("final_adopter_id")
	@Column(name = "final_adopter_id")
	private int finalAdopterId;

	@JsonProperty("pet_breed")
	@Column(name = "pet_breed")
	private String petBreed;

	@JsonProperty("pet_status")
	@Column(name = "pet_status")
	private String petStatus;

	@JsonProperty("adoption_status")
	@Column(name = "adoption_status")
	private String adoptionStatus;

	@JsonProperty("adoption_conditions")
	@Column(name = "adoption_conditions")
	private String adoptionConditions;

	@Column(name = "age")
	private String age;

	@Column(name = "vaccine")
	private String vaccine;

	@JsonProperty("pet_profile")
	@Column(name = "pet_profile")
	private String petProfile;

	@Column(name = "ligation")
	private boolean ligation;

	@Column(name = "type")
	private String type;

	// 12.20 change to BLOB
	@JsonProperty("pet_photo")
	@Column(name = "pet_photo", columnDefinition = "MEDIUMBLOB")
	private byte[] petPhoto;

	@JsonProperty("pet_other_photo")
	@Column(name = "pet_other_photo")
	private String petOtherPhoto;

	@Column(name = "location")
	private String location;

	public PetInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	// for adoption inherit
	public PetInfo(int userId, String petName, String petBreed, String adoptionStatus, String age, String vaccine,
			boolean ligation, String type) {
		super();
		this.userId = userId;
		this.petName = petName;
		this.petBreed = petBreed;
		this.adoptionStatus = adoptionStatus;
		this.age = age;
		this.vaccine = vaccine;
		this.ligation = ligation;
		this.type = type;
	}

	public PetInfo(int userId, String petName, String petBreed, String petStatus, String adoptionStatus, String age,
			String vaccine, String petProfile, boolean ligation, String type, byte[] petPhoto, String location) {
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
		this.location = location;
	}

	public PetInfo(String petId, int userId, String petName, String petBreed, String petStatus, String adoptionStatus,
			String adoptionConditions, String age, String vaccine, String petProfile, boolean ligation, String type,
			byte[] petPhoto, String petOtherPhoto, String location) {
		super();
		this.petId = petId;
		this.userId = userId;
		this.petName = petName;
		this.petBreed = petBreed;
		this.petStatus = petStatus;
		this.adoptionStatus = adoptionStatus;
		this.adoptionConditions = adoptionConditions;
		this.age = age;
		this.vaccine = vaccine;
		this.petProfile = petProfile;
		this.ligation = ligation;
		this.type = type;
		this.petPhoto = petPhoto;
		this.petOtherPhoto = petOtherPhoto;
		this.location = location;
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

	public byte[] getPetPhoto() {
		return petPhoto;
	}

	public void setPetPhoto(byte[] petPhoto) {
		this.petPhoto = petPhoto;
	}

	public String getPetOtherPhoto() {
		return petOtherPhoto;
	}

	public void setPetOtherPhoto(String petOtherPhoto) {
		this.petOtherPhoto = petOtherPhoto;
	}

	public String getLocaiton() {
		return location;
	}

	public void setLocaiton(String location) {
		this.location = location;
	}

}
