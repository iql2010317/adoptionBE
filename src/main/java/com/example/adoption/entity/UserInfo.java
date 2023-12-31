package com.example.adoption.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
//@IdClass(UserInfoId.class)
public class UserInfo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "account")
	private String account;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

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

	@Column(name = "user_photo", columnDefinition = "MEDIUMBLOB")
	private byte[] userPhoto;

	@Column(name = "user_real_name")
	private String userRealName;

	// 12.14 new

	@Column(name = "permission")
	private int permission;

	@Column(name = "register_random_string")
	private String registerRandomString;

	@Column(name = "random_string_time")
	private LocalDateTime randomStringTime;

	@Column(name = "has_opened")
	private boolean hasOpened;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int userId, String userName, String account, String password, String email, String phone,
			String address, String profile, int age, LocalDate birthday, String gender, String jobOccupation,
			String familyStatus, String sentenceToAdopter, byte[] userPhoto, String userRealName, int permission,
			String registerRandomString, LocalDateTime randomStringTime, boolean hasOpened) {
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
		this.userRealName = userRealName;
		this.permission = permission;
		this.registerRandomString = registerRandomString;
		this.randomStringTime = randomStringTime;
		this.hasOpened = hasOpened;
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

	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getRegisterRandomString() {
		return registerRandomString;
	}

	public void setRegisterRandomString(String registerRandomString) {
		this.registerRandomString = registerRandomString;
	}

	public LocalDateTime getRandomStringTime() {
		return randomStringTime;
	}

	public void setRandomStringTime(LocalDateTime randomStringTime) {
		this.randomStringTime = randomStringTime;
	}

	public boolean isHasOpened() {
		return hasOpened;
	}

	public void setHasOpened(boolean hasOpened) {
		this.hasOpened = hasOpened;
	}

}
