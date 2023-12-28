package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.ChatService;
import com.example.adoption.vo.CreateChatRequest;
import com.example.adoption.vo.CreateMessageRequest;
import com.example.adoption.vo.DeleteRoomRequest;
import com.example.adoption.vo.ChatResponse;
import com.example.adoption.vo.MsgAndUserResponse;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

	
	@Autowired
	private ChatService service;
	
	
	
	// create chat room
	@PostMapping(value = "api/adoption/chat/create_room")
	public ChatResponse createChat(@RequestBody CreateChatRequest req) {
		return service.createChat(req.getCreator(), req.getSubscriberList(), req.getName());
	}
	
	
	@PostMapping(value = "api/adoption/chat/delete_room")
	public ChatResponse deleteChat(@RequestBody DeleteRoomRequest req) {
		return service.deleteChat(req.getUserId(), req.getChatRoomId());
	}
	
	
	@PostMapping(value = "api/adoption/chat/create_message")
	public MsgAndUserResponse createMessage(@RequestBody CreateMessageRequest req) {
		return service.createMessage(req.getSender(), req.getText(), req.getChatRoomId());
	}
	
	
}
