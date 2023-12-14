package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.PetInfo;


@Repository
public interface PetInfoDao extends JpaRepository<PetInfo, String>{

	public List<PetInfo> findAllByUserId(int userId);
	
	
}
