package com.example.adoption.service.ifs;

import java.time.LocalDateTime;
import java.util.List;

import com.example.adoption.vo.ChatMsgResponse;
import com.example.adoption.vo.ChatResponse;
import com.example.adoption.vo.ChatRoomResponse;
import com.example.adoption.vo.ChatUserResponse;
import com.example.adoption.vo.MsgAndUserResponse;

public interface ChatService {

	
	public ChatResponse createChat(int creator, String subscriberList, String name);
	
	public ChatResponse deleteChat(int userId, String chatRoomId);
	
	public MsgAndUserResponse createMessage(int sender, String text, String chatRoomId, LocalDateTime timeStamp);
	
	public ChatRoomResponse getChatRooms(int userId);
	
	public ChatUserResponse getChatUsers(String chatRoomIds);
	
	public ChatMsgResponse getMessages(int userId, String chatRoomId);
	
	public ChatUserResponse readMessages(int receiver, String chatRoomId);
	
	
}
