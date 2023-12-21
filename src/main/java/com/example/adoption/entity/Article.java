package com.example.adoption.entity;

import java.sql.Blob;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_article")
public class Article {

	@Id
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "picture")
	private Blob picture;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "post_time")
	private LocalDateTime postTime;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int postId, int userId, String userName, String account, String title, Blob picture,
			String description, LocalDateTime postTime) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.title = title;
		this.picture = picture;
		this.description = description;
		this.postTime = postTime;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	
	
}
