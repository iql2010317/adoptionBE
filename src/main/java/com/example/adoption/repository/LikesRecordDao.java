package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.adoption.entity.LikesRecord;

@ResponseBody
public interface LikesRecordDao extends JpaRepository<LikesRecord, Integer> {

	LikesRecord findByPostIdAndUserId(int postId, int userId);

	List<LikesRecord> findByPostId(int postId);

	List<LikesRecord> findByUserId(int userId);

}
