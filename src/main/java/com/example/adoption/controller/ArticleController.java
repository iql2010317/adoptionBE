package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.ArticleService;
import com.example.adoption.vo.ArticleReq;
import com.example.adoption.vo.ArticleRes;

@RestController
@CrossOrigin
public class ArticleController {

	@Autowired
	private ArticleService service;
	
	@PostMapping(value = "api/adoption/postArticle")
	public ArticleRes create(@RequestBody ArticleReq req) {
		return service.create(req);
	}
}
