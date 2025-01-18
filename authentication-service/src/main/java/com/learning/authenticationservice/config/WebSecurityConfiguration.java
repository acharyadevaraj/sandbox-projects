package com.learning.authenticationservice.config;

import com.learning.authenticationservice.service.CustomUserDetailsService;
import com.learning.authenticationservice.util.JwtTokenAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The {@code WebSecurityConfiguration} class is a configuration class that
 * handles the security configuration for the web application.
 * 
 * @author AcharyaD
 *
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

	private final AuthEntryPointJwt unauthorizedHandler;
	private final CustomUserDetailsService userDetailsService;
	private final JwtTokenAuthFilter jwtTokenAuthFilter;

    public WebSecurityConfiguration(AuthEntryPointJwt unauthorizedHandler, CustomUserDetailsService userDetailsService, JwtTokenAuthFilter jwtTokenAuthFilter) {
        this.unauthorizedHandler = unauthorizedHandler;
        this.userDetailsService = userDetailsService;
        this.jwtTokenAuthFilter = jwtTokenAuthFilter;
    }

    /**
	 * Creates an instance of BCryptPasswordEncoder. It uses the BCrypt hashing
	 * algorithm to securely hash passwords.
	 *
	 * @return An instance of BCryptPasswordEncoder.
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Creates an instance of AuthenticationManager using the provided AuthenticationConfiguration.
	 *
	 * @return An instance of AuthenticationManager.
	 * @throws Exception If an exception occurs during the retrieval process.
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	/**
	 * The authentication provider is responsible for authenticating users based on
	 * their credentials.
	 * 
	 * @return A configured instance of DaoAuthenticationProvider.
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	/**
	 * Configures the security filter chain for handling HTTP security configurations.
	 *
	 * @return A configured instance of SecurityFilterChain.
	 * @throws Exception If an exception occurs during the configuration process.
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/api/auth/**").permitAll()
						.anyRequest().authenticated());
		http.authenticationProvider(authenticationProvider());
		http.addFilterBefore(jwtTokenAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}
