package com.example.adoption.vo;

import com.example.adoption.entity.Notification;

public class NotificationReq {

	private Notification notification;

	public NotificationReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificationReq(Notification notification) {
		super();
		this.notification = notification;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	
	
}
