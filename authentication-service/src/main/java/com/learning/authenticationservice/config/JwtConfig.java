package com.learning.authenticationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code JwtConfig} class is a data class used for configuring JWT (JSON Web Token)
 * settings.
 * 
 * @author AcharyaD
 *
 */

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "security.jwt")
public class JwtConfig {

	private String header;
	private String prefix;
	private String signature;
	private int expiration;
	private String secret;
}
