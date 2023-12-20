package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.NotificationService;
import com.example.adoption.vo.NotificationReq;
import com.example.adoption.vo.NotificationRes;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@PostMapping(value = "api/notification/requestNoti")
	public NotificationRes requestNoti(@RequestBody NotificationReq req) {
		
		return service.requestNoti(req);
	}

	@PostMapping(value = "api/notification/refuseNoti")
	public NotificationRes refuseNoti(@RequestBody NotificationReq req) {
		
		return service.refuseNoti(req);
	}

	@PostMapping(value = "api/notification/Noti")
	public NotificationRes Noti(@RequestBody NotificationReq req) {
		
		return service.Noti(req);
	}

	@GetMapping(value = "api/notification/getNoti")
	public NotificationRes getNoti(@RequestParam(name = "userId") int userId) {
		
		return service.getNoti(userId);
	}
}
