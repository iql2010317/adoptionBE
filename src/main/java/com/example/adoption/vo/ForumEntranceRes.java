package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ForumEntrance;

public class ForumEntranceRes {

	private ForumEntrance forumEntrance;

	private List<ForumEntrance> forumEntranceList;

	private RtnCode rtnCode;

	public ForumEntranceRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForumEntranceRes(ForumEntrance forumEntrance, RtnCode rtnCode) {
		super();
		this.forumEntrance = forumEntrance;
		this.rtnCode = rtnCode;
	}

	public ForumEntranceRes(List<ForumEntrance> forumEntranceList, RtnCode rtnCode) {
		super();
		this.forumEntranceList = forumEntranceList;
		this.rtnCode = rtnCode;
	}

	public ForumEntranceRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public ForumEntranceRes(ForumEntrance forumEntrance) {
		super();
		this.forumEntrance = forumEntrance;
	}

	public ForumEntranceRes(List<ForumEntrance> forumEntranceList) {
		super();
		this.forumEntranceList = forumEntranceList;
	}

	public ForumEntrance getForumEntrance() {
		return forumEntrance;
	}

	public void setForumEntrance(ForumEntrance forumEntrance) {
		this.forumEntrance = forumEntrance;
	}

	public List<ForumEntrance> getForumEntranceList() {
		return forumEntranceList;
	}

	public void setForumEntranceList(List<ForumEntrance> forumEntranceList) {
		this.forumEntranceList = forumEntranceList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

}
