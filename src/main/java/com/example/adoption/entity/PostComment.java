package com.example.adoption.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_comment")
public class PostComment {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "comment_id")
	private int commentId;

	@Column(name = "post_serial_no")
	private int postSerialNo;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "comment_content")
	private String commentContent;

	@Column(name = "comment_time")
	private LocalDateTime commentTime;

	public PostComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostComment(int commentId, int postSerialNo, int userId, String userName, String commentContent,
			LocalDateTime commentTime) {
		super();
		this.commentId = commentId;
		this.postSerialNo = postSerialNo;
		this.userId = userId;
		this.userName = userName;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getPostSerialNo() {
		return postSerialNo;
	}

	public void setPostSerialNo(int postSerialNo) {
		this.postSerialNo = postSerialNo;
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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(LocalDateTime commentTime) {
		this.commentTime = commentTime;
	}

}
