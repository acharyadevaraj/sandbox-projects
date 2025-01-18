package com.security.rolebasedauth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.security.rolebasedauth.model.ErrorObject;

/**
 * The {@code GlobalExceptionHandler} class will handles various custom
 * exceptions in the application and returns appropriate error responses.
 * 
 * @author AcharyaD
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<ErrorObject> handleInternalServerException(InternalServerException exception) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(), exception.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorObject> handleForbiddenException(AccessDeniedException exception) {
		ErrorObject errorObject = new ErrorObject(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(),
				exception.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.FORBIDDEN);
	}

}
