package com.learning.twilionotificationservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.learning.twilionotificationservice.config.TwilioConfig;
import com.learning.twilionotificationservice.entity.SMSNotification;
import com.learning.twilionotificationservice.exception.SMSException;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code SMSService} class contains a method {@code sendSMS} which sends an
 * SMS message using the Twilio API.
 *
 * @author AcharyaD
 */

@Service
@Slf4j
public class SMSService {

    @Autowired
    private TwilioConfig twilioConfig;

    public Message sendSMS(SMSNotification smsObj) {
        try {
            String recipientNumber = smsObj.getCountryCode() + smsObj.getRecipient();
            String senderNumber = twilioConfig.getPhoneNo();
            String message = smsObj.getMessage();

            return Message.creator(new com.twilio.type.PhoneNumber(recipientNumber),
                    new com.twilio.type.PhoneNumber(senderNumber), message).create();
        } catch (Exception e) {
            log.error("Error while sending SMS: {}", e.getMessage());
            throw new SMSException("Failed to send SMS");
        }
    }
}