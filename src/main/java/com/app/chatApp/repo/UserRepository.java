package com.app.chatApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.chatApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 Optional<User> findByUsername(String username);
}
