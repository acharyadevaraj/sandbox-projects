package com.learning.smtpmailservice.exception;

public class EmailException extends RuntimeException {
	public EmailException(String message) {
		super(message);
	}
}
