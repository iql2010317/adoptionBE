package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ChatRoom;
import com.example.adoption.entity.ChatUser;

public class ChatRoomResponse {

	private ChatRoom chatRoom;
	
	private List<ChatRoom> chatRoomList;
	
	private RtnCode rtnCode;

	public ChatRoomResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatRoomResponse(List<ChatRoom> chatRoomList, RtnCode rtnCode) {
		super();
		this.chatRoomList = chatRoomList;
		this.rtnCode = rtnCode;
	}

	public ChatRoomResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public ChatRoomResponse(RtnCode rtnCode, ChatRoom chatRoom) {
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

	public List<ChatRoom> getChatRoomList() {
		return chatRoomList;
	}

	public void setChatRoomList(List<ChatRoom> chatRoomList) {
		this.chatRoomList = chatRoomList;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
	
	
	
}
