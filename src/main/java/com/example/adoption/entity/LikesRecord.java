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
	private int post_id;

	@Column(name = "user_id")
	private int user_id;

	public LikesRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikesRecord(int serial_no, int post_id, int user_id) {
		super();
		this.serial_no = serial_no;
		this.post_id = post_id;
		this.user_id = user_id;
	}

	public int getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
