package com.security.rolebasedauth.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.rolebasedauth.model.UserPrincipal;
import com.security.rolebasedauth.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/***
 * The {@code CustomAuthenticationFilter} class is a custom Spring filter
 * responsible incoming requests.
 * 
 * @author AcharyaD
 *
 */

@Component
@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String username = request.getHeader("username");

		try {
			UserDetails userDetails = identifyUser(username);
			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// Set the authentication in the security context.
		chain.doFilter(request, response);
	}

	private UserDetails identifyUser(String username) {
		return userRepository.findByUsername(username).map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
}
