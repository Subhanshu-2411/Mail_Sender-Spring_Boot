package com.example.mail_senderspring_boot;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailSenderService {

    private final JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String fromEmail, String toEmail, String body, String subject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        simpleMailMessage.setFrom(fromEmail);
        Date date = new Date();
        date.setMinutes(date.getMinutes() + 10);
        simpleMailMessage.setSentDate(date);
        javaMailSender.send(simpleMailMessage);

    }

}
