package com.example.adoption.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.constants.RtnCode;
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
		int postId = likesRecord.getPostId();
		int userId = likesRecord.getUserId();

		// 檢查該使用者是否已經對這篇貼文按過讚
		LikesRecord existingRecord = likesRecordDao.findByPostIdAndUserId(postId, userId);

		if (existingRecord != null) {
			// 取消按讚：刪除該按讚記錄
			likesRecordDao.delete(existingRecord);

			// 找到該篇貼文，並更新按讚計數
			Optional<ForumEntrance> optionalForumEntrance = forumEntranceDao.findById(postId);
			if (optionalForumEntrance.isPresent()) {
				ForumEntrance foundForumEntrance = optionalForumEntrance.get();
				int currentLikesCount = foundForumEntrance.getLikesCount();
				if (currentLikesCount > 0) {
					foundForumEntrance.setLikesCount(currentLikesCount - 1);
					forumEntranceDao.save(foundForumEntrance);
					return new LikesRecordRes(RtnCode.SUCCESSFUL);
				}
			}
		} else {
			// 如果找不到該按讚記錄，表示這是一次新的按讚，執行按讚邏輯
			ForumEntrance foundForumEntrance = forumEntranceDao.findById(postId).orElse(null);
			if (foundForumEntrance != null) {
				foundForumEntrance.setLikesCount(foundForumEntrance.getLikesCount() + 1);
				forumEntranceDao.save(foundForumEntrance);

				LikesRecord savedLikesRecord = likesRecordDao.save(likesRecord);
				return new LikesRecordRes(savedLikesRecord);
			}
		}
		return new LikesRecordRes(RtnCode.PARAM_ERROR); // 在其他情況下返回錯誤狀態碼
	}

	@Override
	public LikesRecordRes searchLikeByPostId(int postId) {
		List<LikesRecord> likesRecords = likesRecordDao.findByPostId(postId);
		return new LikesRecordRes(likesRecords);
	}

	@Override
	public LikesRecordRes searchLikeByUserId(int userId) {
		List<LikesRecord> likesRecords = likesRecordDao.findByUserId(userId);
		return new LikesRecordRes(likesRecords);
	}

}
