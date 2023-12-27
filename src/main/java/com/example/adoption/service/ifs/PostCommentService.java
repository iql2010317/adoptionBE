package com.example.adoption.service.ifs;

import com.example.adoption.vo.PostCommentReq;
import com.example.adoption.vo.PostCommentRes;

public interface PostCommentService {

	public PostCommentRes create(PostCommentReq req);

	public PostCommentRes search();

	public PostCommentRes searchByPostSerialNo(int postSerialNo);

	public PostCommentRes update(PostCommentReq req);

	public PostCommentRes delete(int commentId);

}
