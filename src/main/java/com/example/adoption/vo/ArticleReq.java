package com.example.adoption.vo;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import com.example.adoption.entity.Article;

public class ArticleReq {

	private Article article;
	
	private int postId;

	private int userId;

	private String userName;

	private String account;

	private String title;

	private Blob picture;

	private String description;

	private LocalDateTime postTime;

	private List<Article> articleList;
	
	public ArticleReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArticleReq(List<Article> articleList) {
		super();
		this.articleList = articleList;
	}
	
	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}
	
	

}
