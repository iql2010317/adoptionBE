package com.example.adoption.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes_record")
public class LikesRecord {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "serial_no")
	private int serial_no;

	@Column(name = "post_id")
	private int postId;

	@Column(name = "user_id")
	private int userId;

	public LikesRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikesRecord(int serial_no, int postId, int userId) {
		super();
		this.serial_no = serial_no;
		this.postId = postId;
		this.userId = userId;
	}

	public int getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
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

}
