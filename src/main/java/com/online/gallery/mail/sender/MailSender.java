package com.online.gallery.mail.sender;

import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Async;

public interface MailSender {
    @Async
    void sendConfirmationEmail(String text, String toAddress, String subject) throws MessagingException;
}
