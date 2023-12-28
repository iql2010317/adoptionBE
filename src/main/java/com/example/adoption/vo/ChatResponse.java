package com.example.adoption.vo;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ChatRoom;

public class ChatResponse {
	
	private ChatRoom chatRoom;

	private RtnCode rtnCode;

	public ChatResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}
	
	

	public ChatResponse(ChatRoom chatRoom, RtnCode rtnCode) {
		super();
		this.chatRoom = chatRoom;
		this.rtnCode = rtnCode;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
	
	
}
