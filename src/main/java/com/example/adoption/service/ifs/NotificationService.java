package com.example.adoption.service.ifs;

import com.example.adoption.vo.NotificationReq;
import com.example.adoption.vo.NotificationRes;

public interface NotificationService {
	
	//情況一，請求通知
	public NotificationRes requestNoti(NotificationReq req);

}
