package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.ChatMessage;
@Repository
public interface ChatMessageDao  extends JpaRepository<ChatMessage, Integer>{

	
	public List<ChatMessage> findAllByChatRoomId(String chatRoomId);
}
