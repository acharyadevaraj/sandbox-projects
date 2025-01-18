package com.learning.authenticationservice.util;

import java.io.IOException;

import com.learning.authenticationservice.config.JwtConfig;
import com.learning.authenticationservice.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/***
 * The {@code JwtTokenAuthFilter} class is a custom Spring filter responsible
 * for authenticating and processing JWT authentication for incoming requests.
 * 
 * @author AcharyaD
 *
 */

@Component
public class JwtTokenAuthFilter extends OncePerRequestFilter {

	private final JwtConfig jwtConfig;

	@Autowired
	private JwtTokenManager tokenManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	public JwtTokenAuthFilter(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	/**
	 * Performs the main logic of the filter. It checks if the request contains a
	 * valid JWT token in the request header. If a valid token is found and the user
	 * is not already authenticated, it validates the token, loads user details from
	 * the database, and sets the user's authentication information in the
	 * SecurityContextHolder. The requests will proceed to the next filter in the
	 * filter chain after processing.
	 * 
	 * @param request  The HttpServletRequest object representing the incoming request.
	 * @param response The HttpServletResponse object representing the outgoing response.
	 * @param chain    The FilterChain object for invoking the next filter in the chain.
	 * 
	 * @throws ServletException If a servlet-related error occurs during the filter processing.
	 * @throws IOException      If an I/O-related error occurs during the filter processing.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String header = request.getHeader(jwtConfig.getHeader());
		if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
			chain.doFilter(request, response);
			return;
		}

		String username = null;
		String token = header.replace(jwtConfig.getPrefix(), "");

		username = tokenManager.extractUsername(token);
		if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (tokenManager.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		chain.doFilter(request, response);
	}
}
