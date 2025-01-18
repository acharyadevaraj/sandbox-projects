package com.learning.twilionotificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;
import com.learning.twilionotificationservice.entity.SMSNotification;
import com.learning.twilionotificationservice.service.SMSService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private SMSService smsService;

	@GetMapping("/sendSMS")
	@ResponseStatus(HttpStatus.OK)
	public Message sendSms(@RequestBody SMSNotification sms) {
		return smsService.sendSMS(sms);
	}
}
