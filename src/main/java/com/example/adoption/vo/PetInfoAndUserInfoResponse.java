package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.constants.RtnCode;

public class PetInfoAndUserInfoResponse {
	
	
	private PetInfoAndUserInfoVo vo;
	
	private List<PetInfoAndUserInfoVo> voList;
	
	private RtnCode rtnCode;

	public PetInfoAndUserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetInfoAndUserInfoResponse(PetInfoAndUserInfoVo vo, RtnCode rtnCode) {
		super();
		this.vo = vo;
		this.rtnCode = rtnCode;
	}

	public PetInfoAndUserInfoResponse(List<PetInfoAndUserInfoVo> voList) {
		super();
		this.voList = voList;
	}

	public PetInfoAndUserInfoVo getVo() {
		return vo;
	}

	public void setVo(PetInfoAndUserInfoVo vo) {
		this.vo = vo;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public List<PetInfoAndUserInfoVo> getVoList() {
		return voList;
	}

	public void setVoList(List<PetInfoAndUserInfoVo> voList) {
		this.voList = voList;
	}
	
	
	
}
