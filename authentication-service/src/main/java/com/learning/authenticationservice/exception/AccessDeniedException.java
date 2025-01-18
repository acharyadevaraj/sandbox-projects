package com.learning.authenticationservice.exception;

/**
 * The {@code AccessDeniedException} class is a custom exception that represents
 * an access denied situation.
 * 
 * @author AcharyaD
 *
 */
public class AccessDeniedException extends RuntimeException {
	public AccessDeniedException(String message) {
		super(message);
	}
}
