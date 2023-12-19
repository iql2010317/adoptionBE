package com.example.adoption.service.impl;

import org.springframework.stereotype.Service;

import com.example.adoption.service.ifs.NotificationService;
import com.example.adoption.vo.NotificationReq;
import com.example.adoption.vo.NotificationRes;

@Service
public class NotificationServiceImpl implements NotificationService{
	
	
	
	//情況一，請求通知
	@Override
	public NotificationRes requestNoti(NotificationReq req) {
		// TODO Auto-generated method stub
		int userId = req.getNotification().getUserId();
		int sendId = req.getNotification().getSendId();
		int petId = req.getNotification().getPetId();
		String msg =""; 
		return null;
	}

}
