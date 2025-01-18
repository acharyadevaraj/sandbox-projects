package com.learning.authenticationservice.service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.learning.authenticationservice.exception.EmailAlreadyExistsException;
import com.learning.authenticationservice.exception.UsernameAlreadyExistsException;
import com.learning.authenticationservice.repository.RoleRepository;
import com.learning.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.authenticationservice.exception.ResourceNotFoundException;
import com.learning.authenticationservice.model.Role;
import com.learning.authenticationservice.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code UserService} class is a service responsible for handling
 * user-related operations.
 * 
 * @author AcharyaD
 *
 */

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public User registerUser(User user) {
		log.info("registering user {}", user.getUsername());

		// add check for username exists in database
		if (userRepository.existsByUsername(user.getUsername())) {
			log.warn("username {} already exists.", user.getUsername());
			throw new UsernameAlreadyExistsException(String.format("username %s already exists", user.getUsername()));
		}

		// add check for email exists in database
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyExistsException(String.format("Email is already exists!.", user.getEmail()));
		}

		user.setPassword(new BCryptPasswordEncoder().encode((user.getPassword())));
		Set<Role> roles = new HashSet<Role>();

		Role userRole = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setActive(true);
		user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		return userRepository.save(user);
	}

	public List<User> findAll() {
		log.info("retrieving all users");
		return userRepository.findAll();
	}

	public User findByUsername(String username) {
		log.info("retrieving user {}", username);
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("username %s", username)));
	}

	public Optional<User> findByUsernameOrEmail(String usernameOrEmail) {
		return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
	}
}
