package com.example.adoption.vo;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ChatMessage;
import com.example.adoption.entity.UserInfo;

public class MsgAndUserResponse {
	
	
	/* parameters */
	private ChatMessage msg;
	
	private UserInfo user;
	
	private RtnCode rtnCode;

	
	
	
	
	/* constructors */
	public MsgAndUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MsgAndUserResponse(ChatMessage msg, UserInfo user, RtnCode rtnCode) {
		super();
		this.msg = msg;
		this.user = user;
		this.rtnCode = rtnCode;
	}

	public MsgAndUserResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}
	
	
	
	

	/* getter&setter */
	public ChatMessage getMsg() {
		return msg;
	}

	public void setMsg(ChatMessage msg) {
		this.msg = msg;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
	
	

}
