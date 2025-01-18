package com.learning.authenticationservice.exception;

/**
 * The {@code ResourceNotFoundException} class is a custom exception that represents a 
 * situation where a requested resource is not found in the application.
 * 
 * @author AcharyaD
 *
 */

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String resource) {
		super(String.format("Resource %s not found", resource));
	}
}
