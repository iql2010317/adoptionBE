package com.example.adoption.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.ForumEntrance;
import com.example.adoption.entity.LikesRecord;
import com.example.adoption.repository.ForumEntranceDao;
import com.example.adoption.repository.LikesRecordDao;
import com.example.adoption.service.ifs.LikesRecordService;
import com.example.adoption.vo.LikesRecordReq;
import com.example.adoption.vo.LikesRecordRes;

@Service
public class LikesRecordServiceImpl implements LikesRecordService {

	@Autowired
	private LikesRecordDao likesRecordDao;

	@Autowired
	private ForumEntranceDao forumEntranceDao;

	@Override
	public LikesRecordRes createLike(LikesRecordReq req) {
		LikesRecord likesRecord = req.getLikesRecord();
		int postId = likesRecord.getPost_id();
		ForumEntrance foundForumEntrance = forumEntranceDao.findById(postId).get();
		foundForumEntrance.setLikesCount(foundForumEntrance.getLikesCount() + 1);
		forumEntranceDao.save(foundForumEntrance);

		LikesRecord savedLikesRecord = likesRecordDao.save(likesRecord);
		return new LikesRecordRes(savedLikesRecord);
	}

}
