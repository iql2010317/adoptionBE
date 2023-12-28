package com.example.adoption.vo;

public class CreateMessageRequest {

	
	/* parameters */
	private int sender;
	
	private String text;
	
	private String chatRoomId;

	
	
	
	/* constructors */
	public CreateMessageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateMessageRequest(int sender, String text, String charRoomId) {
		super();
		this.sender = sender;
		this.text = text;
		this.chatRoomId = charRoomId;
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
	
	
}
