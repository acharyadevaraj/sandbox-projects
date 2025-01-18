package com.learning.sendgridmailservice.controller;

import com.learning.sendgridmailservice.entity.EmailNotification;
import com.learning.sendgridmailservice.exception.EmailException;
import com.learning.sendgridmailservice.service.SendGridMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendgrid")
public class NotificationController {

	@Autowired
	private SendGridMailService smtpMailService;

	@PostMapping("/sendMail")
	@ResponseStatus(HttpStatus.OK)
	public String sendMail(@RequestBody EmailNotification email) {
		try {
			return smtpMailService.sendMail(email);
		} catch (Exception e) {
			throw new EmailException("Error while Initiating Mail Sending");
		}
	}
}
