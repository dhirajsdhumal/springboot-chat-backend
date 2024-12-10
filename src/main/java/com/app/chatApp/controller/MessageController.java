package com.app.chatApp.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.chatApp.entity.Message;
import com.app.chatApp.service.MessageService;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins ="http://localhost:4200")
public class MessageController {
	

	 private final MessageService messageService;

	    public MessageController(MessageService messageService) {
	        this.messageService = messageService;
	    }

	    @GetMapping("/{userId}")
	    public List<Message> getMessages(@PathVariable Long userId) {
	        return messageService.getMessages(userId);
	    }

	    @PostMapping
	    public Message sendMessage(@RequestBody MessageRequest request) {
	        return messageService.sendMessage(request.getContent(), request.getSenderId(), request.getReceiverId());
	    }
}

class MessageRequest {
    private String content;
    private Long senderId;
    private Long receiverId;
    public MessageRequest() {
    	
    }
    
	public MessageRequest(String content, Long senderId, Long receiverId) {
		super();
		this.content = content;
		this.senderId = senderId;
		this.receiverId = receiverId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

    
}
