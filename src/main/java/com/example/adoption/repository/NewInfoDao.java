package com.example.adoption.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.NewInfo;

import jakarta.transaction.Transactional;

@Repository
public interface NewInfoDao extends JpaRepository<NewInfo, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="update adoption.new_info set content=?1,date=?2,category=?3,image=?4 where title=?5", nativeQuery = true)
	public int update(String content,LocalDate date,String category,byte[] image,String title);
	

}
