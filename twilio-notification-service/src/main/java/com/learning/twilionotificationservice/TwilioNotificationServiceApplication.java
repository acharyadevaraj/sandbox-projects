package com.learning.twilionotificationservice;


import com.learning.twilionotificationservice.config.TwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.learning.twilionotificationservice.config.TwilioConfig;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TwilioNotificationServiceApplication {

	@Autowired
	private TwilioConfig twilioConfig;

	/**
	 * It is responsible for initializing the Twilio client by configuring it with
	 * the account SID and authentication token from the Twilio configuration.
	 */
	@PostConstruct
	public void initTwilio() {
		try {
			Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
		} catch (Exception e) {
			log.error("Failed to configure the twilio");
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TwilioNotificationServiceApplication.class, args);
	}

}
