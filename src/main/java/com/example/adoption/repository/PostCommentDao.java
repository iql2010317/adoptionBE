package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.PostComment;

@Repository
public interface PostCommentDao extends JpaRepository<PostComment, Integer> {

	List<PostComment> findByPostSerialNo(int postSerialNo);

}
