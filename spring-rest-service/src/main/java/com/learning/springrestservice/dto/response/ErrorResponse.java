package com.learning.springrestservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code ErrorResponse} class represents an error response object that
 * contains information about an exception or error occurred in the application.
 * 
 * @author AcharyaD
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	private int status;
	private String error;
	private String message;
}
