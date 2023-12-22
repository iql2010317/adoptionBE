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
	@Query(value="update adoption.new_info set title=?1,content=?2,date=?3,category=?4,image=?5 where serial_no=?6", nativeQuery = true)
	public int update(String title,String content,LocalDate date,String category,byte[] image,int id);
	
	@Transactional
	@Modifying
	@Query(value="delete from adoption.new_info where serial_no=?1",nativeQuery = true)
	public int delete (int id);
	
	@Transactional
	@Modifying
	@Query(value="insert into  adoption.new_info(title,content,date,category,image) values (?1,?2,?3,?4,?5)",nativeQuery = true)
	public int create(String title,String content,LocalDate date,String category,byte[] image);
	

}
