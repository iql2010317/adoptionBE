package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ChatMessage;

public class ChatMsgResponse {

	
	private List<ChatMessage> chatMsgList;
	
	private RtnCode rtnCode;

	public ChatMsgResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatMsgResponse(List<ChatMessage> chatMsgList, RtnCode rtnCode) {
		super();
		this.chatMsgList = chatMsgList;
		this.rtnCode = rtnCode;
	}

	public ChatMsgResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public List<ChatMessage> getChatMsgList() {
		return chatMsgList;
	}

	public void setChatMsgList(List<ChatMessage> chatMsgList) {
		this.chatMsgList = chatMsgList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
	
}
