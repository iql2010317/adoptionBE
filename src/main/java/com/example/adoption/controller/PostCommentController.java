package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.PostCommentService;
import com.example.adoption.vo.PostCommentReq;
import com.example.adoption.vo.PostCommentRes;

@RestController
@CrossOrigin
public class PostCommentController {

	@Autowired
	PostCommentService postCommentService;

	@PostMapping(value = "api/adoption/createNewComment")
	public PostCommentRes create(@RequestBody PostCommentReq req) {
		return postCommentService.create(req);
	}

	@GetMapping(value = "api/adoption/searchByPostSerialNo")
	public PostCommentRes searchByPostSerialNo(//
			@RequestParam(name = "postSerialNo", required = false) int postSerialNo) {
		return postCommentService.searchByPostSerialNo(postSerialNo);
	}

	@PostMapping(value = "api/adoption/updateComment")
	public PostCommentRes update(@RequestBody PostCommentReq req) {
		return postCommentService.update(req);
	}

	@GetMapping(value = "api/adoption/deleteComment")
	public PostCommentRes delete(//
			@RequestParam(name = "commentId", required = false) int commentId) {
		return postCommentService.delete(commentId);
	}

}
