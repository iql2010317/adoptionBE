package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.adoption.entity.LikesRecord;

@ResponseBody
public interface LikesRecordDao extends JpaRepository<LikesRecord, Integer> {

}
