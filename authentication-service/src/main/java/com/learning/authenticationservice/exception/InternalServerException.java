package com.learning.authenticationservice.exception;

/**
 * The {@code InternalServerException} class is a custom exception that
 * represents an internal server error situation in the application.
 * 
 * @author AcharyaD
 *
 */

public class InternalServerException extends RuntimeException {

	public InternalServerException(String message) {
		super(message);
	}
}