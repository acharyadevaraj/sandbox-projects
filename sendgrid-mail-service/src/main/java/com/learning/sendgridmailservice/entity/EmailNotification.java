package com.learning.sendgridmailservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotification {
	private String recipient;
	private String msgBody;
	private String subject;
}
