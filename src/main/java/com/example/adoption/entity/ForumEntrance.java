package com.example.adoption.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forum_entrance")
public class ForumEntrance {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "serial_no")
	private int serialNo;

	@Column(name = "title")
	private String title;

	@Column(name = "post_content")
	private String postContent;

	@Column(name = "post_photo", columnDefinition = "MEDIUMBLOB")
	private byte[] postPhoto;

	@Column(name = "user_Id")
	private int userId;

	@Column(name = "post_time")
	private LocalDateTime postTime;

	@Column(name = "post_modify_time")
	private LocalDateTime postModifyTime;

	public ForumEntrance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForumEntrance(int serialNo, String title, String postContent, byte[] postPhoto, int userId,
			LocalDateTime postTime, LocalDateTime postModifyTime) {
		super();
		this.serialNo = serialNo;
		this.title = title;
		this.postContent = postContent;
		this.postPhoto = postPhoto;
		this.userId = userId;
		this.postTime = postTime;
		this.postModifyTime = postModifyTime;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public byte[] getPostPhoto() {
		return postPhoto;
	}

	public void setPostPhoto(byte[] postPhoto) {
		this.postPhoto = postPhoto;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	public LocalDateTime getPostModifyTime() {
		return postModifyTime;
	}

	public void setPostModifyTime(LocalDateTime postModifyTime) {
		this.postModifyTime = postModifyTime;
	}

}
