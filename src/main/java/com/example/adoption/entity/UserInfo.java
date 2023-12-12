package com.example.adoption.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
//@IdClass(UserInfoId.class)
public class UserInfo {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
	@Column(name = "user_id")
	private int userId; // PK1 //暫時註解

	@Column(name = "user_name")
	private String userName;

//	@Id
	@Column(name = "account")
	private String account; // PK2 //暫時註解

	@Column(name = "password")
	private String password;

	@Id
	@Column(name = "email")
	private String email; /// 現在email是PK

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "profile")
	private String profile;

	@Column(name = "age")
	private int age;

	@Column(name = "birthday")
	private LocalDate birthday;

	@Column(name = "gender")
	private String gender;

	@Column(name = "job_occupation")
	private String jobOccupation;

	@Column(name = "family_status")
	private String familyStatus;

	@Column(name = "sentence_to_adopter")
	private String sentenceToAdopter;

	@Column(name = "user_photo")
	private String userPhoto;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int userId, String userName, String account, String password, String email, String phone,
			String address, String profile, int age, LocalDate birthday, String gender, String jobOccupation,
			String familyStatus, String sentenceToAdopter, String userPhoto) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.profile = profile;
		this.age = age;
		this.birthday = birthday;
		this.gender = gender;
		this.jobOccupation = jobOccupation;
		this.familyStatus = familyStatus;
		this.sentenceToAdopter = sentenceToAdopter;
		this.userPhoto = userPhoto;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJobOccupation() {
		return jobOccupation;
	}

	public void setJobOccupation(String jobOccupation) {
		this.jobOccupation = jobOccupation;
	}

	public String getFamilyStatus() {
		return familyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}

	public String getSentenceToAdopter() {
		return sentenceToAdopter;
	}

	public void setSentenceToAdopter(String sentenceToAdopter) {
		this.sentenceToAdopter = sentenceToAdopter;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

}
