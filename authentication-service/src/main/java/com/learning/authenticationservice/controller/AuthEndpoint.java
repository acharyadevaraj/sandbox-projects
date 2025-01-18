package com.learning.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.authenticationservice.model.User;
import com.learning.authenticationservice.payload.JwtAuthResponse;
import com.learning.authenticationservice.payload.LoginDto;
import com.learning.authenticationservice.payload.SignUpDto;
import com.learning.authenticationservice.service.UserService;
import com.learning.authenticationservice.util.JwtTokenManager;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code AuthEndpoint} class is a REST controller that handles
 * authentication-related end points.
 * 
 * @author AcharyaD
 *
 */

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthEndpoint {

	@Autowired
	private UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenManager jwtTokenManager;

	@PostMapping(value = { "/register", "/signup" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody SignUpDto payload) {
		log.info("creating user {}", payload.getUsername());

		User user = User.builder().username(payload.getUsername()).email(payload.getEmail())
				.password(payload.getPassword()).mobile(payload.getMobile()).build();
		userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.OK).body("User registered successfully!");
	}

	@PostMapping(value = { "/login", "/signin" })
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenManager.generateToken(authentication);

		JwtAuthResponse response = JwtAuthResponse.builder().token(token).username(loginRequest.getUsernameOrEmail())
				.build();
		return ResponseEntity.ok(response);

	}
}
