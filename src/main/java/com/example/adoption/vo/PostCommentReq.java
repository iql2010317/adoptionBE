package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.PostComment;

public class PostCommentReq {

	private PostComment postComment;

	private List<PostComment> postCommentList;

	public PostCommentReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostCommentReq(PostComment postComment) {
		super();
		this.postComment = postComment;
	}

	public PostCommentReq(List<PostComment> postCommentList) {
		super();
		this.postCommentList = postCommentList;
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

}
