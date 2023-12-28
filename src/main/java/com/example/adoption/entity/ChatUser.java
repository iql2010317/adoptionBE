package com.example.adoption.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_user")
public class ChatUser {

	
	/* parameters */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "sender")
	private int sender;

	@Column(name = "receiver")
	private int receiver;

	@Column(name = "chat_room_id")
	private String chatRoomId;

	@Column(name = "is_read")
	private Boolean read;

	@Column(name = "read_time")
	private LocalDateTime readTime;
	
	
	
	
	/* constructors */
	public ChatUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatUser(int sender, int receiver, String chatRoomId, Boolean read) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.chatRoomId = chatRoomId;
		this.read = read;
	}

	
	
	
	/* getter&setter */
	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public int getId() {
		return id;
	}
	
	
}
