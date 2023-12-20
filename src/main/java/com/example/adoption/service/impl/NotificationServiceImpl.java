package com.example.adoption.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.Notification;
import com.example.adoption.entity.PetInfo;
import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.NotificationDao;
import com.example.adoption.repository.PetInfoDao;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.NotificationService;
import com.example.adoption.vo.NotificationReq;
import com.example.adoption.vo.NotificationRes;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private UserInfoDao userDao;

	@Autowired
	private PetInfoDao petDao;

	@Autowired
	private NotificationDao notiDao;

	// 情況一，請求通知
	// 領養人(sendId) 向 送養人(userId) 發通知，送樣人接收通知
	@Override
	@Transactional
	public NotificationRes requestNoti(NotificationReq req) {
		// req = userid sendid petid
		// 請求進來的ID找其他資料
		int userId = req.getNotification().getUserId();
		int sendId = req.getNotification().getSendId();
		String petId = req.getNotification().getPetId();

		//////////////////////////////////////////////////////////////
		// 防呆 找不到ID
		if (!userDao.existsById(userId) || !userDao.existsById(sendId) || !petDao.existsById(petId)) {
			return new NotificationRes(null, RtnCode.ID_NOT_FOUND);
		}
		//////////////////////////////////////////////////////////////

		// 送養人名稱
		UserInfo userData = userDao.selectByUserId(userId);

		// 領養人名稱
		UserInfo sendData = userDao.selectByUserId(sendId);

		// 送養人要寵物名稱
		PetInfo petData = petDao.selectByPetId(petId);

		// 防呆，找出資料為空
		if (petData == null) {
			return new NotificationRes(null, RtnCode.DATA_NOT_FOUNT);
		}

		String userName = userData.getUserName();
		String sendName = sendData.getUserName();
		String petName = petData.getPetName();

		// 提示訊息
		String msg = "將訊息送至 Id: " + userId + " Name: " + userName;
		// 通知內容
		String notifiContain = sendName + " 想要領養你的寵物 " + petName;

		// 已讀狀態
		boolean isRead = false;
		// 發通知的時間
		LocalDateTime dateTime = LocalDateTime.now();
		int notifiType = req.getNotification().getNotifiType();
		Notification notifi = new Notification(userId, sendId, petId, notifiContain, msg, isRead, dateTime,notifiType);
		notiDao.save(notifi);
		return new NotificationRes(null, RtnCode.SUCCESSFUL);
	}

	
	// 情況二，送養人拒絕領養人的請求
	// 送養人 (sendId) 向 領養人(userId) 發通知，領養人接收通知
	@Override
	public NotificationRes refuseNoti(NotificationReq req) {
		// req = userid sendid petid notifiType
		// 請求進來的ID找其他資料
		int userId = req.getNotification().getUserId();//領
		int sendId = req.getNotification().getSendId();//送
		String petId = req.getNotification().getPetId();//送P

		//////////////////////////////////////////////////////////////
		// 防呆 找不到ID
		if (!userDao.existsById(userId) || !userDao.existsById(sendId) || !petDao.existsById(petId)) {
			return new NotificationRes(null, RtnCode.ID_NOT_FOUND);
		}
		//////////////////////////////////////////////////////////////

		// 領養人名稱
		UserInfo userData = userDao.selectByUserId(userId);

		// 送養人名稱
		UserInfo sendData = userDao.selectByUserId(sendId);

		// 送養人要寵物名稱
		PetInfo petData = petDao.selectByPetId(petId);

		// 防呆，找出資料為空
		if (petData == null) {
			return new NotificationRes(null, RtnCode.DATA_NOT_FOUNT);
		}

		String userName = userData.getUserName();
		String sendName = sendData.getUserName();
		String petName = petData.getPetName();

		// 提示訊息
		String msg = "將訊息送至 Id: " + userId + " Name: " + userName;//傳給領
		// 通知內容
		String notifiContain = sendName + " 已拒絕您領養 " + petName+" 的要求";

		// 已讀狀態
		boolean isRead = false;
		// 發通知的時間
		LocalDateTime dateTime = LocalDateTime.now();
		//
		int notifiType = req.getNotification().getNotifiType();
		Notification notifi = new Notification(userId, sendId, petId, notifiContain, msg, isRead, dateTime,notifiType);
		notiDao.save(notifi);
		return new NotificationRes(null, RtnCode.SUCCESSFUL);

	}
	
	@Override
	public NotificationRes Noti(NotificationReq req) {
		// req = userid收信人 sendid寄信人 petid notifiType通知類型
		
		
			
		
		// 請求進來的ID找其他資料
		int userId = req.getNotification().getUserId();
		int sendId = req.getNotification().getSendId();
		String petId = req.getNotification().getPetId();
		Optional<UserInfo> userData = userDao.findById(userId);
		Optional<UserInfo> sendData = userDao.findById(sendId);
		Optional<PetInfo> petData = petDao.findById(petId);

		String userName = userData.get().getUserName();
		String sendName = sendData.get().getUserName();
		String petName = petData.get().getPetName();

		// 提示訊息 傳訊息給收信人
		String msg = "將訊息送至 Id: " + userId + " Name: " + userName;//傳給領
		
		// 記錄通知種類
		int notifiType = req.getNotification().getNotifiType();

		// 通知內容
		/*
		1.領養人對送養人發請求，user是送養人，send是領養人
		2.領養人收回他的請求，user是送養人，send是領養人
		3.送養人同意領養人請求，user是領養人，send是送養人
		4.送養人拒絕領養人請求，user是領養人，send是送養人
		5.領養人同意送養人的同意，user是送養人，send領養人
		6.領養人拒絕送養人的同意，user是送養人，send領養人
		*/
		String notifiContain = "";
		switch (notifiType) {
		case 1:
			notifiContain = sendName + " 想要領養你的寵物 " + petName;
			break;
		case 2:
			notifiContain = sendName + " 已收回他的請求";
			
			break;
		case 3:
			notifiContain = sendName + " 已同意您領養 " + petName+" 的要求，請確認是否真的要領養";
			break;
		case 4:
			notifiContain = sendName + " 已拒絕您領養 " + petName+" 的要求";			
			break;
		case 5:
			notifiContain = sendName + " 已接受領養 " + petName;
			break;
		case 6:
			notifiContain = sendName + " 拒絕領養 " + petName;
			break;

		}

		// 已讀狀態
		boolean isRead = false;
		// 發通知的時間
		LocalDateTime dateTime = LocalDateTime.now();
		
		Notification notifi = new Notification(userId, sendId, petId, notifiContain, msg, isRead, dateTime,notifiType);
		notiDao.save(notifi);
		List<Notification> notifiList = new ArrayList<>();
		notifiList.add(notifi);
		return new NotificationRes(notifiList, RtnCode.SUCCESSFUL);

	}


	@Override
	public NotificationRes getNoti(int userId) {
		List<Notification> notifiList = notiDao.selectNotificationByUserId(userId);
		return new NotificationRes(notifiList, RtnCode.SUCCESSFUL);
	}


	@Override
	public NotificationRes setNotiRead(int userId) {
		List<Notification> notifiList = notiDao.selectNotificationByUserId(userId);
		for(Notification noti:notifiList) {
			noti.setRead(true);
		}
		notiDao.saveAll(notifiList);
		
		return new NotificationRes(null, RtnCode.SUCCESSFUL);
	}
	
	

}
