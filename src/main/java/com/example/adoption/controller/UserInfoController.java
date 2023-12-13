package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

@RestController
@CrossOrigin
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping(value = "api/adoption/userInfo/createUserInfo")
	public UserInfoResponse create(@RequestBody UserInfoRequest req) {
		return userInfoService.create(req);
	}
	
	//§ó·sÅÞ¿è
	@PostMapping(value = "api/adoption/userInfo/updateUserInfo")
	public UserInfoResponse update(@RequestBody UserInfoRequest req) {
		return userInfoService.update(req);
	}

	@GetMapping(value = "api/adoption/userInfo/searchAllUserInfo")
	public UserInfoResponse search() {
		return userInfoService.search();
	}

	@GetMapping(value = "api/adoption/userInfo/login")
	public boolean userLogin(@RequestParam(value = "account", required = false) String account, //
			@RequestParam(value = "password", required = false) String password) {
		return userInfoService.userLogin(account, password);
	}

}
