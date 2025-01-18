package com.learning.authenticationservice.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.authenticationservice.model.ErrorObject;

/**
 * The {@code GlobalExceptionHandler} class will handles various custom
 * exceptions in the application and returns appropriate error responses.
 * 
 * @author AcharyaD
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorObject> handleAccessDeniedException(AccessDeniedException exception) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name(),
				exception.getMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorObject> handleBadCredentialsException(BadCredentialsException exception) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name(),
				exception.getMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorObject> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<ErrorObject> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException exception) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				exception.getMessage());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}
}
