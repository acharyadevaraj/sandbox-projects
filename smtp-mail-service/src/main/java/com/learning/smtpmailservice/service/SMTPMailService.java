package com.learning.smtpmailservice.service;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.learning.smtpmailservice.entity.EmailNotification;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.learning.smtpmailservice.exception.EmailException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SMTPMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendMail(EmailNotification email) throws ExecutionException, InterruptedException {
        Callable<String> sendEmailCallable = () -> {
            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(sender);
                mailMessage.setTo(email.getRecipient());
                mailMessage.setText(email.getMsgBody());
                mailMessage.setSubject(email.getSubject());

                javaMailSender.send(mailMessage);
                return "Mail Sent Successfully...";
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new EmailException("Error while Sending Mail");
            }
        };

        log.info("Mail sending initiated...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(sendEmailCallable);
        String response = future.get();

        executorService.shutdown();
        return response;
    }

    public String sendMailWithAttachment(EmailNotification email) throws ExecutionException, InterruptedException {
        Callable<String> sendEmailCallable = () -> {
            try {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage, true);

                mailMessage.setFrom(sender);
                mailMessage.setTo(email.getRecipient());
                mailMessage.setText(email.getMsgBody());
                mailMessage.setSubject(email.getSubject());
                FileSystemResource file = new FileSystemResource(new File(email.getAttachment()));
                mailMessage.addAttachment(file.getFilename(), file);

                javaMailSender.send(mimeMessage);
                return "Mail Sent Successfully...";
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new EmailException("Error while Sending Mail");
            }
        };

        log.info("Mail sending initiated...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(sendEmailCallable);
        String response = future.get();

        executorService.shutdown();
        return response;
    }
}
