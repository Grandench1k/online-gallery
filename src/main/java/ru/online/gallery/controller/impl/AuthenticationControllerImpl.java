package ru.online.gallery.controller.impl;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.online.gallery.controller.AuthenticationController;
import ru.online.gallery.entity.*;
import ru.online.gallery.entity.responses.OkResponse;
import ru.online.gallery.service.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody @Validated RegisterRequest request) throws MessagingException {
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping("activate/{token}")
    public ResponseEntity<OkResponse> activateUser(@PathVariable String token) {
        return ResponseEntity.ok(new OkResponse(service.activate(token)));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody @Validated AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("password/forgot")
    public ResponseEntity<OkResponse> forgotPassword(@RequestBody @Validated PasswordResetRequest passwordResetRequest) throws MessagingException {
        return ResponseEntity.ok(new OkResponse(service.sendMessageForReset(passwordResetRequest.getEmail())));
    }

    @GetMapping("password/reset/{token}")
    public ResponseEntity<OkResponse> confirmPasswordResetPage(@PathVariable String token) {
        return ResponseEntity.ok(new OkResponse(service.checkPasswordResetTokenAndUser(token)));
    }

    @PostMapping("password/reset/{token}")
    public ResponseEntity<OkResponse> confirmPasswordReset(
            @PathVariable String token,
            @RequestBody @Validated PasswordResetConfirmationRequest passwordResetConfirmationRequest) {
        return ResponseEntity.ok(new OkResponse(service.resetPassword(token, passwordResetConfirmationRequest.getPassword())));
    }
}
