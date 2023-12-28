package com.example.adoption.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.ChatMessage;
import com.example.adoption.entity.ChatRoom;
import com.example.adoption.entity.ChatUser;
import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.ChatMessageDao;
import com.example.adoption.repository.ChatRoomDao;
import com.example.adoption.repository.ChatUserDao;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.ChatService;
import com.example.adoption.vo.ChatMsgResponse;
import com.example.adoption.vo.ChatResponse;
import com.example.adoption.vo.ChatUserResponse;
import com.example.adoption.vo.MsgAndUserResponse;


@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private UserInfoDao userDao;
	
	@Autowired
	private ChatRoomDao chatRoomDao;
	
	@Autowired
	private ChatMessageDao chatMsgDao;
	
	@Autowired
	private ChatUserDao chatUserDao;

	@Override
	public ChatResponse createChat(int creator, String subscriberList, String name) {
		
		// check parameters
		if(creator == 0 || creator < 0 || !StringUtils.hasText(subscriberList)) {
			return new ChatResponse(RtnCode.PARAM_ERROR);
		}
		
		// check if the creator exist
		if(!userDao.existsById(creator)) {
			return new ChatResponse(RtnCode.NOT_FOUND);
		}
		
		// check if there's already have the same subscriberList
		ChatRoom foundRoom = chatRoomDao.findBySubscriberList(subscriberList);
		if(foundRoom != null) {
			return new ChatResponse(foundRoom, RtnCode.SUCCESSFUL);
		}
		
		// 1. 将逗号分隔的字符串拆分为数组
        String[] strArray = subscriberList.split(",");
        
        // 2. 轉成陣列
        List<String> list = new ArrayList<>(Arrays.asList(strArray));
        int ent = 0;
        
		if(list.size() == 2) {
			ent = 1;
		}
		
        ChatRoom lastChatRoom = chatRoomDao.findTopByEntOrderByChatRoomIdDesc(ent);
        
        ChatRoom create = new ChatRoom(ent, name, subscriberList, creator);
        
		if (lastChatRoom == null) {
			create.setChatRoomId(ent + "R1");
		} else {
			String lastChatRoomId = lastChatRoom.getChatRoomId();
			String numericPart = lastChatRoomId.substring(2);// 获取字符串的第三个字符开始的部分
			long lastPetIdLong = Long.parseLong(numericPart); // 将提取的字符串部分转换为 long 类型
			create.setChatRoomId(ent + "R" + (lastPetIdLong + 1));
		}
		
		create.setCreateTime(LocalDateTime.now());
		
		try {
			chatRoomDao.save(create);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ChatResponse(RtnCode.SAVE_DB_ERROR);
		}
		
		return new ChatResponse(create, RtnCode.SUCCESSFUL);
	}

	
	
	
	@Override
	public ChatResponse deleteChat(int userId, String chatRoomId) {
		
		// check parameters
		if(userId == 0 || userId < 0 || !StringUtils.hasText(chatRoomId)) {
			return new ChatResponse(RtnCode.PARAM_ERROR);
		}
		
		// check if exist
		ChatRoom foundRoom = chatRoomDao.findByChatRoomId(chatRoomId);
		if(foundRoom == null) {
			return new ChatResponse(RtnCode.NOT_FOUND);
		}
		
		// check if the user is the creator
		if(foundRoom.getCreator() != userId) {
			return new ChatResponse(RtnCode.INSUFFICIENT_PERMISSIONS);
		}
		
		try {
			chatRoomDao.deleteById(foundRoom.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ChatResponse(RtnCode.SAVE_DB_ERROR);
		}
		
		return new ChatResponse(RtnCode.SUCCESSFUL);
	}

	@Override
	public MsgAndUserResponse createMessage(int sender, String text, String chatRoomId) {
		
		// check parameters
		if(sender == 0 || sender < 0 || !StringUtils.hasText(text)) {
			return new MsgAndUserResponse(RtnCode.PARAM_ERROR);
		}
		
		// check if the chat room exist
		ChatRoom foundRoom = chatRoomDao.findByChatRoomId(chatRoomId);
		if(foundRoom == null) {
			return new MsgAndUserResponse(RtnCode.NOT_FOUND);
		}
		
		ChatMessage msg = new ChatMessage(foundRoom.getEnt(), LocalDateTime.now(), chatRoomId, sender, text);
		
		// check if the user exist
		Optional<UserInfo> foundUser = userDao.findById(sender);
		if(foundUser.isEmpty()) {
			return new MsgAndUserResponse(RtnCode.NOT_FOUND);
		}
		
		UserInfo user = foundUser.get();
		
		// get the subscriber
		String[] idList = foundRoom.getSubscriberList().split(",");
		List<Integer> intIdList = Arrays.stream(idList)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
		// set the subscribers to the chat user list
		List<ChatUser> userList = new ArrayList<>();
		
		for(Integer id : intIdList) {
			if(id == sender) {
				continue;
			}
			ChatUser chatUser = new ChatUser(sender, id, chatRoomId, false);
			userList.add(chatUser);
		}
		
		
		try {
			chatMsgDao.save(msg);
			chatUserDao.saveAll(userList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new MsgAndUserResponse(RtnCode.SAVE_DB_ERROR);
		}
		
		return new MsgAndUserResponse(msg, user, RtnCode.SUCCESSFUL);
	}




	@Override
	public ChatUserResponse getChatUsers(int userId) {
		
		// check parameters
		if(userId == 0 || userId < 0) {
			return new ChatUserResponse(RtnCode.PARAM_ERROR);
		}
		
		List<ChatUser> foundList = chatUserDao.findAllByReceiver(userId);
		
		return new ChatUserResponse(foundList, RtnCode.SUCCESSFUL);
	}




	@Override
	public ChatMsgResponse getMessages(int userId, String chatRoomId) {
		
		// check parameters
		if(userId == 0 || userId < 0 || !StringUtils.hasText(chatRoomId)) {
			return new ChatMsgResponse(RtnCode.PARAM_ERROR);
		}
		
		// check if the chat room id is exist
		ChatRoom foundRoom = chatRoomDao.findByChatRoomId(chatRoomId);
		if(foundRoom == null) {
			return new ChatMsgResponse(RtnCode.NOT_FOUND);
		}
		
		List<ChatMessage> foundMsg = chatMsgDao.findAllByChatRoomId(chatRoomId);
		
		
		return new ChatMsgResponse(foundMsg, RtnCode.SUCCESSFUL);
	}

}
