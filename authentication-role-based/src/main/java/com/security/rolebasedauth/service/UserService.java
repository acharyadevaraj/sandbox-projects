package com.security.rolebasedauth.service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.rolebasedauth.exception.InternalServerException;
import com.security.rolebasedauth.model.Role;
import com.security.rolebasedauth.model.User;
import com.security.rolebasedauth.repository.RoleRepository;
import com.security.rolebasedauth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public User registerUser(User user) {
		log.info("registering user {}", user.getUsername());

		if (userRepository.existsByUsername(user.getUsername())) {
			log.warn("username {} already exists.", user.getUsername());
			throw new InternalServerException(String.format("username %s already exists", user.getUsername()));
		}

		Set<Role> roles = new HashSet<Role>();
		Role userRole = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setActive(true);
		user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		return userRepository.save(user);
	}
}
