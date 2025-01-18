package com.security.rolebasedauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.rolebasedauth.model.UserPrincipal;
import com.security.rolebasedauth.repository.UserRepository;

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
	 * Loads user details based on the provided username. If the user is
	 * found, it creates a UserPrincipal object representing the authenticated user
	 * and returns it.
	 * 
	 * @param username The username of the user to load details for.
	 * @return UserPrincipal object representing the authenticated user if found.
	 * @throws UsernameNotFoundException If the user is not found.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username).map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
}
