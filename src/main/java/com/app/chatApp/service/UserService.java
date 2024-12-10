package com.app.chatApp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.chatApp.entity.User;
import com.app.chatApp.repo.UserRepository;


@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }


    public boolean login(User user) {
        // Check if the user exists in the database by username
        return userRepository.findByUsername(user.getUsername())
                .filter(existingUser -> existingUser.getPassword().equals(user.getPassword()))
                .isPresent();
    }


	public List<User> getuser() {
		return userRepository.findAll();
	}
}
