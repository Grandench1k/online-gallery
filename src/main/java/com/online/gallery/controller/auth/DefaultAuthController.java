package com.online.gallery.controller.auth;

import com.online.gallery.dto.request.PasswordResetCompleteRequest;
import com.online.gallery.dto.request.PasswordResetStartRequest;
import com.online.gallery.dto.request.SignInRequest;
import com.online.gallery.dto.request.SignUpRequest;
import com.online.gallery.dto.response.AuthTokenResponse;
import com.online.gallery.dto.response.MessageResponse;
import com.online.gallery.service.auth.AuthService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/auth")
public class DefaultAuthController implements AuthController {
    private final AuthService service;

    public DefaultAuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthTokenResponse> processSignUp(
            @RequestBody @Valid SignUpRequest request) throws MessagingException {
        return ResponseEntity.ok(service.processSignUp(request));
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity<AuthTokenResponse> completeSignUp(@PathVariable String token) {
        return ResponseEntity.ok(service.completeSignUp(token));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthTokenResponse> signIn(
            @RequestBody @Valid SignInRequest request) {
        return ResponseEntity.ok(service.signIn(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<MessageResponse> logOut() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(new MessageResponse("successful logout"));
    }

    @PostMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        service.refreshToken(request, response);
    }

    @PostMapping("/password")
    public ResponseEntity<MessageResponse> forgotPassword(
            @RequestBody @Valid PasswordResetStartRequest passwordResetStartRequest
    ) throws MessagingException {
        return ResponseEntity.ok(new MessageResponse(
                service.sendMessageForResetPassword(passwordResetStartRequest.getEmail())));
    }

    @GetMapping("/password/{token}")
    public ResponseEntity<MessageResponse> startPasswordReset(@PathVariable String token) {
        return ResponseEntity.ok(new MessageResponse(service.processPasswordReset(token)));
    }

    @PostMapping("/password/{token}")
    public ResponseEntity<MessageResponse> completePasswordReset(
            @RequestBody @Valid PasswordResetCompleteRequest passwordResetCompleteRequest,
            @PathVariable String token) {
        return ResponseEntity.ok(new MessageResponse(
                service.completePasswordReset(token, passwordResetCompleteRequest.getPassword())));
    }
}

