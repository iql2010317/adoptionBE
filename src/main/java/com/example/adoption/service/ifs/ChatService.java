package com.example.adoption.service.ifs;

import com.example.adoption.vo.ChatMsgResponse;
import com.example.adoption.vo.ChatResponse;
import com.example.adoption.vo.ChatUserResponse;
import com.example.adoption.vo.MsgAndUserResponse;

public interface ChatService {

	
	public ChatResponse createChat(int creator, String subscriberList, String name);
	
	public ChatResponse deleteChat(int userId, String chatRoomId);
	
	public MsgAndUserResponse createMessage(int sender, String text, String chatRoomId);
	
	public ChatUserResponse getChatUsers(int userId);
	
	public ChatMsgResponse getMessages(int userId, String chatRoomId);
	
	
}
