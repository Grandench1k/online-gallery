package ru.online.gallery.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.online.gallery.entity.AuthenticationRequest;
import ru.online.gallery.entity.AuthenticationResponse;
import ru.online.gallery.entity.RegisterRequest;
import ru.online.gallery.exceptions.UserAlreadyDefined;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request) throws UserAlreadyDefined, MessagingException;

    AuthenticationResponse authenticate(AuthenticationRequest request) throws UsernameNotFoundException;

    String activate(String token);

    String sendMessageForReset(String token) throws MessagingException;

    String checkPasswordResetTokenAndUser(String token);

    String resetPassword(String token, String newPassword);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
