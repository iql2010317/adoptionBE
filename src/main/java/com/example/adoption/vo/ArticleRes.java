package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.Article;

public class ArticleRes {

	private Article article;
	
	private List<Article> articleList;
	
	public ArticleRes() {
		super();
	}
	
	public ArticleRes(List<Article> articleList) {
		super();
		this.articleList =articleList;
	}
	public ArticleRes(Article article) {
		super();
		this.article =article;
	}


	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
}
