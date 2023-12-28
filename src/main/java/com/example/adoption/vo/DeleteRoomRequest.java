package com.example.adoption.vo;

public class DeleteRoomRequest {

	
	/* parameters */
	private int userId;
	
	private String chatRoomId;

	
	
	
	/* constructors */
	public DeleteRoomRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteRoomRequest(int userId, String chatRoomId) {
		super();
		this.userId = userId;
		this.chatRoomId = chatRoomId;
	}

	
	
	
	/* getter&setter */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	
}
