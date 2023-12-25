package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.adoption.entity.Notification;
import com.example.adoption.entity.PetInfo;

import jakarta.annotation.Resource;

@Resource
public interface NotificationDao extends JpaRepository<Notification, Integer>{
	
	@Query(value = "SELECT * FROM notification n WHERE n.user_id = :userId", nativeQuery = true)
	public List<Notification> selectNotificationByUserId(@Param("userId")int userId);

	@Query
	public boolean existsByUserId(int userId);
	
}
