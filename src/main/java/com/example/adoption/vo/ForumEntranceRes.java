package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.ForumEntrance;

public class ForumEntranceRes {

	private ForumEntrance forumEntrance;

	private List<ForumEntrance> forumEntranceList;

	public ForumEntranceRes() {
		super();
		// TODO Auto-generated constructor stub
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

}
