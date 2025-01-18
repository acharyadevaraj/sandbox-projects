package com.learning.authenticationservice.exception;

/**
 * The {@code EmailAlreadyExistsException} class is a custom exception that
 * represents a situation where an attempt is made to register a user with an
 * email address that already exists in the application's database or system.
 * 
 * @author AcharyaD
 *
 */

public class EmailAlreadyExistsException extends RuntimeException {

	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
