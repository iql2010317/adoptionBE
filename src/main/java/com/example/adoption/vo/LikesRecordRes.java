package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.LikesRecord;

public class LikesRecordRes {

	private LikesRecord likesRecord;

	private List<LikesRecord> likesRecordList;

	private RtnCode rtnCode;

	public LikesRecordRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikesRecordRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public LikesRecordRes(LikesRecord likesRecord) {
		super();
		this.likesRecord = likesRecord;
	}

	public LikesRecordRes(List<LikesRecord> likesRecordList) {
		super();
		this.likesRecordList = likesRecordList;
	}

	public LikesRecordRes(LikesRecord likesRecord, RtnCode rtnCode) {
		super();
		this.likesRecord = likesRecord;
		this.rtnCode = rtnCode;
	}

	public LikesRecordRes(List<LikesRecord> likesRecordList, RtnCode rtnCode) {
		super();
		this.likesRecordList = likesRecordList;
		this.rtnCode = rtnCode;
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

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

}
