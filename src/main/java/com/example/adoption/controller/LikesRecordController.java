package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.LikesRecordService;
import com.example.adoption.vo.LikesRecordReq;
import com.example.adoption.vo.LikesRecordRes;

@RestController
@CrossOrigin
public class LikesRecordController {

	@Autowired
	private LikesRecordService likesRecordService;

	@PostMapping(value = "api/adoption/createLike")
	public LikesRecordRes createLike(@RequestBody LikesRecordReq req) {
		return likesRecordService.createLike(req);
	}

	@GetMapping(value = "api/adoption/searchLikeByPostId")
	public LikesRecordRes searchLikeByPostId(//
			@RequestParam(name = "postId", required = false) int postId) {
		return likesRecordService.searchLikeByPostId(postId);
	}

	@GetMapping(value = "api/adoption/searchLikeByUserId")
	public LikesRecordRes searchLikeByUserId(//
			@RequestParam(name = "userId", required = false) int userId) {
		return likesRecordService.searchLikeByUserId(userId);
	}

}
