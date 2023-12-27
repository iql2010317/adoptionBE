package com.example.adoption.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PostComment;
import com.example.adoption.repository.PostCommentDao;
import com.example.adoption.service.ifs.PostCommentService;
import com.example.adoption.vo.PostCommentReq;
import com.example.adoption.vo.PostCommentRes;

@Service
public class PostCommentServiceImpl implements PostCommentService {

	@Autowired
	private PostCommentDao postCommentDao;

	@Override
	public PostCommentRes create(PostCommentReq req) {
		PostComment PostComment = req.getPostComment();

		LocalDateTime currentDateTime = LocalDateTime.now();
		PostComment.setCommentTime(currentDateTime);

		PostComment savedPostComment = postCommentDao.save(PostComment);
		return new PostCommentRes(savedPostComment, RtnCode.SUCCESSFUL);
	}

	@Override
	public PostCommentRes search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostCommentRes searchByPostSerialNo(int postSerialNo) {
		List<PostComment> postCommentList = postCommentDao.findByPostSerialNo(postSerialNo);
		return new PostCommentRes(postCommentList, RtnCode.SUCCESSFUL);
	}

	@Override
	public PostCommentRes update(PostCommentReq req) {

		PostComment postComment = req.getPostComment();
		Optional<PostComment> existop = postCommentDao.findById(postComment.getCommentId());
		if (existop.isPresent()) {
			PostComment existPostComment = existop.get();

			if (postComment.getCommentContent() != null) {
				existPostComment.setCommentContent(postComment.getCommentContent());
			}
			PostComment savedPostComment = postCommentDao.save(existPostComment);
			return new PostCommentRes(savedPostComment, RtnCode.SUCCESSFUL);

		}
		return new PostCommentRes(RtnCode.ID_NOT_FOUND);
	}

	@Override
	public PostCommentRes delete(int commentId) {
		PostComment existPostComment = postCommentDao.findById(commentId).get();
		postCommentDao.delete(existPostComment);
		return new PostCommentRes(RtnCode.SUCCESSFUL);
	}

}
