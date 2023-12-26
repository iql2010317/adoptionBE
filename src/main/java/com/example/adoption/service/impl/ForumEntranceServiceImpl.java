package com.example.adoption.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.ForumEntrance;
import com.example.adoption.repository.ForumEntranceDao;
import com.example.adoption.service.ifs.ForumEntranceService;
import com.example.adoption.vo.ForumEntranceReq;
import com.example.adoption.vo.ForumEntranceRes;

@Service
public class ForumEntranceServiceImpl implements ForumEntranceService {

	@Autowired
	ForumEntranceDao forumEntranceDao;

	@Override
	public ForumEntranceRes create(ForumEntranceReq req) {
		ForumEntrance forumEntrance = req.getForumEntrance();

		LocalDateTime currentDateTime = LocalDateTime.now();
		forumEntrance.setPostTime(currentDateTime);

		ForumEntrance savedForumEntrance = forumEntranceDao.save(forumEntrance);
		return new ForumEntranceRes(savedForumEntrance);
	}

	@Override
	public ForumEntranceRes search() {
		List<ForumEntrance> forumEntranceList = forumEntranceDao.findAll();
		return new ForumEntranceRes(forumEntranceList);
	}

	@Override
	public ForumEntranceRes searchById(int serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumEntranceRes update(ForumEntranceReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumEntranceRes delete(int serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
