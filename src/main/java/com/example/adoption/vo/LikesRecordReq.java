package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.LikesRecord;

public class LikesRecordReq {

	private LikesRecord likesRecord;

	private List<LikesRecord> likesRecordList;

	public LikesRecordReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikesRecordReq(LikesRecord likesRecord) {
		super();
		this.likesRecord = likesRecord;
	}

	public LikesRecordReq(List<LikesRecord> likesRecordList) {
		super();
		this.likesRecordList = likesRecordList;
	}

	public LikesRecord getLikesRecord() {
		return likesRecord;
	}

	public void setLikesRecord(LikesRecord likesRecord) {
		this.likesRecord = likesRecord;
	}

	public List<LikesRecord> getLikesRecordList() {
		return likesRecordList;
	}

	public void setLikesRecordList(List<LikesRecord> likesRecordList) {
		this.likesRecordList = likesRecordList;
	}

}
