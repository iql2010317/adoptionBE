package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.ForumEntranceService;
import com.example.adoption.vo.ForumEntranceReq;
import com.example.adoption.vo.ForumEntranceRes;

@RestController
@CrossOrigin
public class ForumEntranceController {

	@Autowired
	ForumEntranceService forumEntranceService;

	@PostMapping(value = "api/adoption/createNewPost")
	public ForumEntranceRes create(@RequestBody ForumEntranceReq req) {
		return forumEntranceService.create(req);
	}

	@GetMapping(value = "api/adoption/searchAllPost")
	public ForumEntranceRes search() {
		return forumEntranceService.search();
	}

	@PostMapping(value = "api/adoption/updatePost")
	public ForumEntranceRes update(@RequestBody ForumEntranceReq req) {
		return forumEntranceService.update(req);
	}

	@GetMapping(value = "api/adoption/deletePost")
	public ForumEntranceRes delete(//
			@RequestParam(name = "serialNo", required = false) int serialNo) {
		return forumEntranceService.delete(serialNo);
	}

}
