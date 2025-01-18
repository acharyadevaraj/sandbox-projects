package com.learning.twilionotificationservice.exception;

/**
 * The {@code SMSException} class it is used to represent exceptions related to
 * sending SMS messages.
 * 
 * @author AcharyaD
 *
 */
public class SMSException extends RuntimeException {
	public SMSException(String message) {
		super(message);
	}
}
