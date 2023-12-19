package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.Notification;

public class NotificationRes {
	
	private List<Notification> notifiReq;
	
	private RtnCode rtnCode;

	public NotificationRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificationRes(List<Notification> notifiReq, RtnCode rtnCode) {
		super();
		this.notifiReq = notifiReq;
		this.rtnCode = rtnCode;
	}

	public List<Notification> getNotifiReq() {
		return notifiReq;
	}

	public void setNotifiReq(List<Notification> notifiReq) {
		this.notifiReq = notifiReq;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
}
