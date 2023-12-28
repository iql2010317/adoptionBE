package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.ChatRoom;

@Repository
public interface ChatRoomDao extends JpaRepository<ChatRoom, Integer>{

	public ChatRoom findTopByEntOrderByChatRoomIdDesc(int ent);
	
	public ChatRoom findBySubscriberList(String subscriberList);
	
	public ChatRoom findByChatRoomId(String chatRoomId);
}
