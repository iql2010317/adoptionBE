package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ChatUser;

public class ChatUserResponse {

	private ChatUser chatUser;
	
	private List<ChatUser> chatUserList;
	
	private RtnCode rtnCode;

	public ChatUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatUserResponse(List<ChatUser> chatUserList, RtnCode rtnCode) {
		super();
		this.chatUserList = chatUserList;
		this.rtnCode = rtnCode;
	}

	public ChatUserResponse(ChatUser chatUser, RtnCode rtnCode) {
		super();
		this.chatUser = chatUser;
		this.rtnCode = rtnCode;
	}

	public ChatUserResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public List<ChatUser> getChatUserList() {
		return chatUserList;
	}

	public void setChatUserList(List<ChatUser> chatUserList) {
		this.chatUserList = chatUserList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public ChatUser getChatUser() {
		return chatUser;
	}

	public void setChatUser(ChatUser chatUser) {
		this.chatUser = chatUser;
	}
	
	
}
