package com.example.adoption.service.ifs;

import com.example.adoption.vo.LikesRecordReq;
import com.example.adoption.vo.LikesRecordRes;

public interface LikesRecordService {

	public LikesRecordRes createLike(LikesRecordReq req);
}
