package com.security.rolebasedauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	
	@GetMapping("/userPoint")
	public String userEndpoint() {
		return "All user access";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/adminPoint")
	public String adminEndpoint() {
		return "Only admin access";
	}

}
