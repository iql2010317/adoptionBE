package com.example.adoption.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.Article;
import com.example.adoption.repository.ArticleDao;
import com.example.adoption.service.ifs.ArticleService;
import com.example.adoption.vo.ArticleReq;
import com.example.adoption.vo.ArticleRes;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleDao articleDao;
	
	@Override
	public ArticleRes create(ArticleReq req) {
		Article article = req.getArticle();
		Article saveArticle = articleDao.save(article);
		return new ArticleRes(saveArticle);
	}

	
}
