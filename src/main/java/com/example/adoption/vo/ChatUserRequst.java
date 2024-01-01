package com.example.adoption.vo;

public class ChatUserRequst {

	
	private int receiver;
	
	private String chatRoomId;

	public ChatUserRequst() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatUserRequst(int receiver, String chatRoomId) {
		super();
		this.receiver = receiver;
		this.chatRoomId = chatRoomId;
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
	
	
}
