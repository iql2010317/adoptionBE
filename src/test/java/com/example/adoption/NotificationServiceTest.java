package com.example.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adoption.entity.Notification;
import com.example.adoption.service.ifs.NotificationService;
import com.example.adoption.vo.NotificationReq;
import com.example.adoption.vo.NotificationRes;

import jakarta.annotation.Resource;

@SpringBootTest
public class NotificationServiceTest {

	@Autowired
	private NotificationService service;
	
	@Test
	public void requestNotiTest() {
		//54:negi有2隻pet
		//57:negi222，想領其中一隻P5402
		Notification notifi = new Notification(57,54,"P5402",1);
		NotificationReq req = new NotificationReq(notifi);
		try {
		    NotificationRes res = service.requestNoti(req);
//		    System.out.println(res.getNotifiReq().getMsg());
//		    System.out.println(res.getNotifiReq().getNotifiContain());
		    
		} catch (Exception e) {
		    System.err.println(e.getMessage());
		}
		
	}

	@Test
	public void setNotiReadTest() {

		service.setNotiRead(54);
	}
	

}
