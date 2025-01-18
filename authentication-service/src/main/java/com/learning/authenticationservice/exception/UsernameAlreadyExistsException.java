package com.learning.authenticationservice.exception;

/**
 * The {@code UsernameAlreadyExistsException} class is a custom exception that
 * represents a situation where an attempt is made to register a user
 * with a username that already exists in the application's database or system.
 * 
 * @author AcharyaD
 *
 */

public class UsernameAlreadyExistsException extends RuntimeException {

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
}
