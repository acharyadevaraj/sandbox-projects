package com.security.rolebasedauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.rolebasedauth.dto.UserDto;
import com.security.rolebasedauth.model.User;
import com.security.rolebasedauth.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User registerUser(UserDto payload) {
		log.info("creating user {}", payload.getUsername());
		User user = User.builder().username(payload.getUsername()).build();
		return userService.registerUser(user);
	}
}
