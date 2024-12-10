package com.app.chatApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.chatApp.entity.Message;
import com.app.chatApp.entity.User;
import com.app.chatApp.repo.MessageRepository;
import com.app.chatApp.repo.UserRepository;

@Service
public class MessageService {
	  private final MessageRepository messageRepository;
	  
	    private final UserRepository userRepository;

	    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
	        this.messageRepository = messageRepository;
	        this.userRepository = userRepository;
	    }

	    public List<Message> getMessages(Long userId) {
	        return messageRepository.findBySenderIdOrReceiverId(userId, userId);
	    }

	    public Message sendMessage(String content, Long senderId, Long receiverId) {
	        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Sender not found"));
	        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Receiver not found"));

	        Message message = new Message();
	        message.setContent(content);
	        message.setSender(sender);
	        message.setReceiver(receiver);

	        // Update unread count
	        
	        userRepository.save(receiver);

	        return messageRepository.save(message);
	    }
	
}
