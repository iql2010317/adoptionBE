package com.example.adoption.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.adoption.entity.ChatRoom;
import com.example.adoption.entity.ChatUser;

@Repository
public interface ChatRoomDao extends JpaRepository<ChatRoom, Integer>{

	public ChatRoom findTopByEntOrderByChatRoomIdDesc(int ent);
	
	public ChatRoom findBySubscriberList(String subscriberList);
	
	public ChatRoom findByChatRoomId(String chatRoomId);
	
	
	@Query(value = "SELECT * FROM chat_room WHERE FIND_IN_SET(:userId, subscriber_list) > 0", nativeQuery = true)
	public List<ChatRoom>  findAllBySubscriberListContaining(@Param(value = "userId")String userId);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE ChatRoom AS room SET"
			+ " lastTimeStamp = CASE WHEN :lastTimeStamp is null THEN room.lastTimeStamp ELSE :lastTimeStamp END,"
			+ " lastMsg = CASE WHEN :lastMsg is null THEN room.lastMsg ELSE :lastMsg END,"
			+ " lastSender = CASE WHEN :lastSender is null THEN room.lastSender ELSE :lastSender END"
			+ " WHERE room.chatRoomId = :chatRoomId")
	public int updateLastTimeStampAndLastMessageAndLastSender(
			@Param("chatRoomId")String chatRoomId, 
			@Param("lastTimeStamp")LocalDateTime lastTimeStamp, 
			@Param("lastMsg")String lastMsg,
			@Param("lastSender")int lastSender);
}
