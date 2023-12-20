package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.NewInfo;

@Repository
public interface NewInfoDao extends JpaRepository<NewInfo, Integer> {
	
}
