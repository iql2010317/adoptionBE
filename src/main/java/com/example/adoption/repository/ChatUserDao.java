package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.ChatUser;

@Repository
public interface ChatUserDao extends JpaRepository<ChatUser, Integer>{

	
	public List<ChatUser> findAllByReceiver(int userId);
}
