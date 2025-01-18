package com.learning.smtpmailservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learning.smtpmailservice.entity.ErrorObject;

/**
 * The {@code GlobalException} class is responsible for handling exceptions that
 * occur within the application.
 * 
 * @author AcharyaD
 *
 */

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<ErrorObject> handleResourceNotFoundException(EmailException exp) {
		ErrorObject errObj = new ErrorObject();
		errObj.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errObj.setMessage(exp.getMessage());
		errObj.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errObj, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
