package com.learning.twilionotificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code SMS} class is typically used when sending SMS messages, where the
 * recipient and message content need to be specified.
 * 
 * @author AcharyaD
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SMSNotification {
	private String recipient;
	private String countryCode;
	private String message;
}
