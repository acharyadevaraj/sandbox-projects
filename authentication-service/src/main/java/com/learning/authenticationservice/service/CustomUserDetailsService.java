package com.learning.authenticationservice.service;

import com.learning.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.authenticationservice.model.UserPrincipal;

/**
 * The {@code CustomUserDetailsService} class provides a custom implementation
 * for loading user details during the authentication process.
 * 
 * @author AcharyaD
 *
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Loads user details based on the provided username or email. If the user is
	 * found, it creates a UserPrincipal object representing the authenticated user
	 * and returns it.
	 * 
	 * @param usernameOrEmail The username or email of the user to load details for.
	 * @return UserPrincipal object representing the authenticated user if found.
	 * @throws UsernameNotFoundException If the user is not found.
	 */
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
}
