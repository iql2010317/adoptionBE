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
@CrossOrigin(origins = "http://localhost:5173")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping(value = "api/adoption/userInfo/createUserInfo")
	public UserInfoResponse create(@RequestBody UserInfoRequest req) {
		return userInfoService.create(req);
	}

	@PostMapping(value = "api/adoption/userInfo/compare")
	public UserInfoResponse compareAuthenticationCode(@RequestBody UserInfoRequest req) {
		return userInfoService.compareAuthenticationCode(req);
	}

	// ��s�޿�
	@PostMapping(value = "api/adoption/userInfo/updateUserInfo")
	public UserInfoResponse update(@RequestBody UserInfoRequest req) {
		return userInfoService.update(req);
	}

	@GetMapping(value = "api/adoption/userInfo/searchAllUserInfo")
	public UserInfoResponse search() {
		return userInfoService.search();
	}

	@GetMapping(value = "api/adoption/userInfo/login")
	public String userLogin(@RequestParam(value = "email", required = false) String email, //
			@RequestParam(value = "password", required = false) String password) {
		return userInfoService.userLogin(email, password);
	}

	@GetMapping(value = "api/adoption/userInfo/userFogetPassword")
	public String userFogetPassword(@RequestParam(value = "email", required = false) String email) {
		return userInfoService.userFogetPassword(email);
	}

	@GetMapping(value = "api/adoption/userInfo/forceChangePassword")
	public String forceChangePassword(//
			@RequestParam(value = "email", required = false) String email, //
			@RequestParam(value = "newPassword", required = false) String newPassword, //
			@RequestParam(value = "confirmPassword", required = false) String confirmPassword) {
		return userInfoService.forceChangePassword(email, newPassword, confirmPassword);
	}
<<<<<<< HEAD
=======


>>>>>>> cc794125a405de22fdfa8a90b6cb6be3774300a6
	
	//12.19 this one for search user
	@GetMapping(value = "api/adoption/userInfo/finduser")
	public UserInfoResponse searchById(//
			@RequestParam(value = "userId", required = false) int userId) {
		return userInfoService.searchById(userId);
	}
<<<<<<< HEAD
=======

>>>>>>> cc794125a405de22fdfa8a90b6cb6be3774300a6

}