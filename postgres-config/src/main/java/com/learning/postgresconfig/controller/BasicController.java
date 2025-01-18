package com.learning.postgresconfig.controller;

import com.learning.postgresconfig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BasicController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getDataFromDb")
	public List<String> getDataFromDb() {
		return userService.getUserNameList();
	}
}