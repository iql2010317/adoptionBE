package com.example.adoption.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

	//AI
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	
	//表示此使用者的通知欄
	@Column(name = "user_id")
	private int userId;
	
	//向此使用者傳送訊息的ID
	@Column(name = "send_id")
	private int sendId;
	
	//送領養寵物的ID
	@Column(name = "pet_id")
	private int petId;
	
	//傳送的訊息
	@Column(name = "msg")
	private String msg;
	
	//是否已讀
	@Column(name = "isread")
	private boolean isRead;
	
	//這條通知的時間點
	@Column(name = "date_time")
	private LocalDateTime dateTime;

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(int userId, int sendId, int petId, String msg, boolean isRead, LocalDateTime dateTime) {
		super();
		this.userId = userId;
		this.sendId = sendId;
		this.petId = petId;
		this.msg = msg;
		this.isRead = isRead;
		this.dateTime = dateTime;
	}

	
	
	public Notification(int userId, int sendId, int petId) {
		super();
		this.userId = userId;
		this.sendId = sendId;
		this.petId = petId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
