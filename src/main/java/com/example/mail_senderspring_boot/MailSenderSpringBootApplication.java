package com.example.mail_senderspring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderSpringBootApplication {

    private final EmailSenderService emailSenderService;

    public MailSenderSpringBootApplication(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MailSenderSpringBootApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() {
        emailSenderService.sendEmail(
                "subhanshu20135@iiitd.ac.in",
                "subhanshu20135@iiitd.ac.in",
                "Body",
                "Subject"
                );
    }

}
