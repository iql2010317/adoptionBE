package com.example.adoption.entity;

import java.io.Serializable;

@SuppressWarnings("serial") //¼È®É¤£¥Î
public class UserInfoId implements Serializable {

	private int userId; // PK1

	private String account; // PK2

	public UserInfoId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoId(int userId, String account) {
		super();
		this.userId = userId;
		this.account = account;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
