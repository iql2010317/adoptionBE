package com.example.adoption.vo;

import java.time.LocalDateTime;

public class CreateMessageRequest {

	
	/* parameters */
	private int sender;
	
	private String text;
	
	private String chatRoomId;
	
	private LocalDateTime timeStamp;

	
	
	
	/* constructors */
	public CreateMessageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateMessageRequest(int sender, String text, String charRoomId, LocalDateTime timeStamp) {
		super();
		this.sender = sender;
		this.text = text;
		this.chatRoomId = charRoomId;
		this.timeStamp = timeStamp;
	}

	
	
	
	/* getter&setter */
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

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
