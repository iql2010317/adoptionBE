package com.example.adoption.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_message")
public class ChatMessage {

	
	/* parameters */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "ent")
	private int ent;

	@Column(name = "time_stamp")
	private LocalDateTime timeStamp;

	@Column(name = "chat_room_id")
	private String chatRoomId;

	@Column(name = "sender")
	private int sender;

	@Column(name = "text")
	private String text;

	
	
	
	/* constructors */
	public ChatMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatMessage(int ent, LocalDateTime timeStamp, String chatRoomId, int sender, String text) {
		super();
		this.ent = ent;
		this.timeStamp = timeStamp;
		this.chatRoomId = chatRoomId;
		this.sender = sender;
		this.text = text;
	}

	
	
	
	/* getter&setter */
	public int getEnt() {
		return ent;
	}

	public void setEnt(int ent) {
		this.ent = ent;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}
	
	
	
}
