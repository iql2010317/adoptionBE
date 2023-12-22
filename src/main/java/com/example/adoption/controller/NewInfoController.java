package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.repository.NewInfoDao;
import com.example.adoption.service.ifs.NewInfoService;
import com.example.adoption.vo.InfoReq;
import com.example.adoption.vo.InfoRes;
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

	//修改
	@PostMapping(value = "api/adoption/updateUserInfo")
	public int update(@RequestBody InfoReq req) {

		return newInfoDao.update(req.getTitle(),req.getContent(),req.getDate(),req.getCategory(),req.getImage(),req.getSerialNo());

	}
	
	//刪除
	@PostMapping(value = "api/adoption/deleteNewUserInfo")
	public int deletee(@RequestBody InfoReq req) {

		return newInfoDao.delete(req.getSerialNo());

	}
	
	//新增
	@PostMapping(value="ccc123")
	public InfoRes create(@RequestBody InfoReq req) {
		 newInfoDao.create(req.getTitle(),req.getContent(),req.getDate(),req.getCategory(),req.getImage());
		return new InfoRes();
	}
	
}
