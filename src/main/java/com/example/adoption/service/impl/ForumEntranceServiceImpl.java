package com.example.adoption.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.constants.RtnCode;
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
		return new ForumEntranceRes(savedForumEntrance, RtnCode.SUCCESSFUL);
	}

	@Override
	public ForumEntranceRes search() {
		List<ForumEntrance> forumEntranceList = forumEntranceDao.findAll();
		return new ForumEntranceRes(forumEntranceList, RtnCode.SUCCESSFUL);
	}

	@Override
	public ForumEntranceRes searchById(int serialNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumEntranceRes update(ForumEntranceReq req) {
		// req來的新變數
		ForumEntrance forumEntrance = req.getForumEntrance();

		Optional<ForumEntrance> existop = forumEntranceDao.findById(forumEntrance.getSerialNo());
		if (existop.isPresent()) {

			// 透過findById 得到的exist
			ForumEntrance existForumEntrance = existop.get();

			// 若更新資訊不為空 則讓新變數 set到exist內
			if (forumEntrance.getTitle() != null) {
				existForumEntrance.setTitle(forumEntrance.getTitle());
			}

			if (forumEntrance.getPostContent() != null) {
				existForumEntrance.setPostContent(forumEntrance.getPostContent());
			}

			if (forumEntrance.getPostPhoto() != null) {
				existForumEntrance.setPostPhoto(forumEntrance.getPostPhoto());
			}

			LocalDateTime currentDateTime = LocalDateTime.now();
			existForumEntrance.setPostModifyTime(currentDateTime);

			// 儲存更新後的資料
			ForumEntrance savedForumEntrance = forumEntranceDao.save(existForumEntrance);
			return new ForumEntranceRes(savedForumEntrance, RtnCode.SUCCESSFUL);
		}
		return new ForumEntranceRes(RtnCode.ID_NOT_FOUND);
	}

	@Override
	public ForumEntranceRes delete(int serialNo) {
		ForumEntrance existForumEntrance = forumEntranceDao.findById(serialNo).get();
		forumEntranceDao.delete(existForumEntrance);
		return new ForumEntranceRes(RtnCode.SUCCESSFUL);
	}

}
