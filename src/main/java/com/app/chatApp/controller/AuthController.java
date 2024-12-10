package com.app.chatApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.chatApp.entity.User;
import com.app.chatApp.service.UserService;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="http://localhost:4200")
public class AuthController {
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
    	 boolean isValidUser = userService.login(user);
    	    if (isValidUser) {
    	        return ResponseEntity.ok(Map.of("message", "Login successful", "token", "sample-jwt-token"));
    	    } else {
    	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid username or password"));
    	    }
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getuser();
    }
    
    
}
