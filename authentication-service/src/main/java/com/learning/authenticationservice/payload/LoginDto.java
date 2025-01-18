package com.learning.authenticationservice.payload;

import lombok.Data;

/**
 * The {@code LoginDto} class is a simple Java POJO representing a data transfer
 * object for user login credentials.
 * 
 * @author AcharyaD
 *
 */

@Data
public class LoginDto {
	private String usernameOrEmail;
	private String password;
}
