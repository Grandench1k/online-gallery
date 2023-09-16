package ru.online.gallery.mail;

import org.springframework.mail.javamail.JavaMailSender;

public interface MailConfiguration {
    JavaMailSender getJavaMailSender();
}
