package com.learning.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code ErrorObject} class represents an error response object that
 * contains information about an exception or error occurred in the application.
 * 
 * @author AcharyaD
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {
	private int status;
	private String error;
	private String message;
}
