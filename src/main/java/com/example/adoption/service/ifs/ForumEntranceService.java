package com.example.adoption.service.ifs;

import com.example.adoption.vo.ForumEntranceReq;
import com.example.adoption.vo.ForumEntranceRes;

public interface ForumEntranceService {

	public ForumEntranceRes create(ForumEntranceReq req);

	public ForumEntranceRes search();

	public ForumEntranceRes searchById(int serialNo);

	public ForumEntranceRes update(ForumEntranceReq req);

	public ForumEntranceRes delete(int serialNo);

}
