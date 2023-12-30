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
public interface ChatUserDao extends JpaRepository<ChatUser, Integer>{

	
	public List<ChatUser> findAllByReceiver(int userId);
	
	public List<ChatUser> findAllByChatRoomIdIn(String[] chatRoomId);
	
	public List<ChatUser> findAllByChatRoomIdAndSender(String chatRoomId, int sender);
	
	public ChatUser findByChatRoomIdAndReceiver(String chatRoomId, int receiver);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE ChatUser AS user SET"
			+ " read = CASE WHEN :read is null THEN user.read ELSE :read END,"
			+ " readTime = CASE WHEN :readTime is null THEN user.readTime ELSE :readTime END"
			+ " WHERE user.chatRoomId = :chatRoomId AND user.receiver = :receiver")
	public int updateRead(
			@Param("chatRoomId")String chatRoomId,
			@Param("receiver")int receiver,
			@Param("read")Boolean read, 
			@Param("readTime")LocalDateTime readTime);
}
