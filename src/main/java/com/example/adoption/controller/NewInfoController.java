package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.repository.NewInfoDao;
import com.example.adoption.service.ifs.NewInfoService;
import com.example.adoption.vo.NewInfoRequest;
import com.example.adoption.vo.NewInfoResponse;

@RestController
@CrossOrigin
public class NewInfoController {

	@Autowired
	private NewInfoService newInfoService;

	@Autowired
	private NewInfoDao newInfoDao;

	@PostMapping(value = "api/adoption/createNewInfo")
	public NewInfoResponse create(@RequestBody NewInfoRequest req) {
		return newInfoService.create(req);
	}

	@GetMapping(value = "api/adoption/searchAllNewUserInfo")
	public NewInfoResponse search() {
		return newInfoService.search();
	}

	@PostMapping(value = "api/adoption/updateInfo")
	public int update(@RequestBody NewInfoRequest req) {

		return newInfoDao.update(req.getNewInfo().getContent(), req.getNewInfo().getDate(),
				req.getNewInfo().getCategory(), req.getNewInfo().getImage(), req.getNewInfo().getTitle());

	}
}
