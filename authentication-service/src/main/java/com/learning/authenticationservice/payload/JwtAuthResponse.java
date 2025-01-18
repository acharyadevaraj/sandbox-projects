package com.learning.authenticationservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code JwtAuthResponse} class is a simple Java POJO representing the
 * response object for JWT authentication.
 * 
 * @author AcharyaD
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtAuthResponse {
	private String token;
	private String username;
}
