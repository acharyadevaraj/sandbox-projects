package com.learning.sendgridmailservice.service;

import com.learning.sendgridmailservice.entity.EmailNotification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.learning.sendgridmailservice.exception.EmailException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendGridMailService {

	@Value("${sendgrid.email.api-key}")
	private String apiKey;

	@Value("${sendgrid.email.sender}")
	private String sender;

	public String sendMail(EmailNotification email) {

		Email from = new Email(sender);
		String subject = email.getSubject();
		Email to = new Email(email.getRecipient());
		Content content = new Content("text/plain", email.getMsgBody());
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apiKey);
		Request request = new Request();

		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			Response response = sg.api(request);
			return "Email sent successfully. Status code: " + response.getStatusCode();
		} catch (Exception e) {
			log.error("Failed to send email. Error: " + e.getMessage());
			throw new EmailException("Failed to send email.");
		}
	}
}
