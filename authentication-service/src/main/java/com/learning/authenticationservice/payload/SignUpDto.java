package com.learning.authenticationservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code SignUpDto} class is a simple Java POJO representing a data
 * transfer object for user sign-up information.
 * 
 * @author AcharyaD
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

	private String name;
	private String username;
	private String email;
	private long mobile;
	private String password;
}
