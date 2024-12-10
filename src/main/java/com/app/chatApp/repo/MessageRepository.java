package com.app.chatApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.chatApp.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
	    List<Message> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
	
}
