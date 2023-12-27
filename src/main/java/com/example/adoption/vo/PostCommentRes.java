package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PostComment;

public class PostCommentRes {

	private PostComment postComment;

	private List<PostComment> postCommentList;

	private RtnCode rtnCode;

	public PostCommentRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostCommentRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public PostCommentRes(PostComment postComment) {
		super();
		this.postComment = postComment;
	}

	public PostCommentRes(List<PostComment> postCommentList) {
		super();
		this.postCommentList = postCommentList;
	}

	public PostCommentRes(PostComment postComment, RtnCode rtnCode) {
		super();
		this.postComment = postComment;
		this.rtnCode = rtnCode;
	}

	public PostCommentRes(List<PostComment> postCommentList, RtnCode rtnCode) {
		super();
		this.postCommentList = postCommentList;
		this.rtnCode = rtnCode;
	}

	public PostComment getPostComment() {
		return postComment;
	}

	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}

	public List<PostComment> getPostCommentList() {
		return postCommentList;
	}

	public void setPostCommentList(List<PostComment> postCommentList) {
		this.postCommentList = postCommentList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

}
