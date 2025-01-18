package com.learning.twilionotificationservice.entity;

import lombok.Data;

/**
 * The {@code ErrorObject} class is commonly used with exception management to
 * provide meaningful error responses.
 * 
 * @author AcharyaD
 *
 */
@Data
public class ErrorObject {
	private int status;
	private String message;
	private long timestamp;
}
