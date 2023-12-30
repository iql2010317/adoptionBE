package com.example.adoption.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_room")
public class ChatRoom {

	
	/* parameters */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "ent")
	private int ent;

	@Column(name = "chat_room_id")
	private String chatRoomId;
	
	@Column(name = "last_time_stamp")
	private LocalDateTime lastTimeStamp;

	@Column(name = "last_message")
	private String lastMsg;
	
	@Column(name = "last_sender")
	private int lastSender;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "subscriber_list")
	private String subscriberList;
	
	@Column(name = "creator")
	private int creator;
	
	@Column(name = "create_time")
	private LocalDateTime createTime;

	
	
	
	/* constructors */
	public ChatRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatRoom(int ent, String chatRoomId, LocalDateTime lastTimeStamp, String lastMsg, String name,
			String subscriberList, int creator, LocalDateTime createTime) {
		super();
		this.ent = ent;
		this.chatRoomId = chatRoomId;
		this.lastTimeStamp = lastTimeStamp;
		this.lastMsg = lastMsg;
		this.name = name;
		this.subscriberList = subscriberList;
		this.creator = creator;
		this.createTime = createTime;
	}
	
	
	public ChatRoom(int ent, String name, String subscriberList, int creator) {
		super();
		this.ent = ent;
		this.name = name;
		this.subscriberList = subscriberList;
		this.creator = creator;
	}

	/* getter&setter */
	public int getEnt() {
		return ent;
	}

	public void setEnt(int ent) {
		this.ent = ent;
	}

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	public LocalDateTime getLastTimeStamp() {
		return lastTimeStamp;
	}

	public void setLastTimeStamp(LocalDateTime lastTimeStamp) {
		this.lastTimeStamp = lastTimeStamp;
	}

	public String getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubscriberList() {
		return subscriberList;
	}

	public void setSubscriberList(String subscriberList) {
		this.subscriberList = subscriberList;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public int getLastSender() {
		return lastSender;
	}

	public void setLastSender(int lastSender) {
		this.lastSender = lastSender;
	}
	
	
	
	
}
