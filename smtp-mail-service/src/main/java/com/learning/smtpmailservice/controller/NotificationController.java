package com.learning.smtpmailservice.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learning.smtpmailservice.entity.EmailNotification;
import com.learning.smtpmailservice.exception.EmailException;
import com.learning.smtpmailservice.service.SMTPMailService;

@RestController
@RequestMapping("/smtp")
public class NotificationController {

    @Autowired
    private SMTPMailService smtpMailService;

    @PostMapping("/sendMail")
    @ResponseStatus(HttpStatus.OK)
    public String sendMail(@RequestBody EmailNotification email) {
        try {
            return smtpMailService.sendMail(email);
        } catch (ExecutionException | InterruptedException e) {
            throw new EmailException("Error while Initiating Mail Sending");
        }
    }

    @PostMapping("/sendMailWithAttachment")
    @ResponseStatus(HttpStatus.OK)
    public String sendMailWithAttachment(@RequestBody EmailNotification email) {
        try {
            return smtpMailService.sendMailWithAttachment(email);
        } catch (ExecutionException | InterruptedException e) {
            throw new EmailException("Error while Initiating Mail Sending");
        }
    }
}
