package com.example.adoption.service.ifs;

import com.example.adoption.vo.NotificationReq;
import com.example.adoption.vo.NotificationRes;

public interface NotificationService {
	
	//情況一，請求通知
	public NotificationRes requestNoti(NotificationReq req);
	
	//情況二，領養人收回他的請求
	public NotificationRes refuseNoti(NotificationReq req);

	public NotificationRes Noti(NotificationReq req);

	public NotificationRes getNoti(int userId);
}
