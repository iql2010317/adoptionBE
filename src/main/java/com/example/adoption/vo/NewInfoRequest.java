package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.NewInfo;

public class NewInfoRequest {

	private NewInfo newInfo;

	private List<NewInfo> newInfoList;

	public NewInfoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewInfoRequest(NewInfo newInfo) {
		super();
		this.newInfo = newInfo;

	}

	public NewInfoRequest(List<NewInfo> newInfoList) {
		super();
		this.newInfoList = newInfoList;
	}

	public NewInfo getNewInfo() {
		return newInfo;
	}

	public void setNewInfo(NewInfo newInfo) {
		this.newInfo = newInfo;
	}

	public List<NewInfo> getNewInfoList() {
		return newInfoList;
	}

	public void setNewInfoList(List<NewInfo> newInfoList) {
		this.newInfoList = newInfoList;
	}

}
