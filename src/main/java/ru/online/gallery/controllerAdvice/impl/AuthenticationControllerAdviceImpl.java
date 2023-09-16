package ru.online.gallery.controllerAdvice.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.online.gallery.controller.AuthenticationController;
import ru.online.gallery.controllerAdvice.AuthenticationControllerAdvice;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exceptions.*;

@RestControllerAdvice(basePackageClasses = AuthenticationController.class)
public class AuthenticationControllerAdviceImpl implements AuthenticationControllerAdvice {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<NotFoundResponse> handleNotFound(UserNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(e.getMessage()));
    }

    @ExceptionHandler(UsernameNotFound.class)
    public ResponseEntity<NotFoundResponse> handleNotFound(UsernameNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(e.getMessage()));
    }

    @ExceptionHandler(UserAlreadyDefined.class)
    public ResponseEntity<BadRequestResponse> handleAlreadyDefined(UserAlreadyDefined e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }

    @ExceptionHandler(UserNotEnabled.class)
    public ResponseEntity<BadRequestResponse> handleUserNotEnabled(UserNotEnabled e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }

    @ExceptionHandler(ConfirmationTokenExpired.class)
    public ResponseEntity<BadRequestResponse> handleConfirmationTokenIsExpired(ConfirmationTokenExpired e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }
    @ExceptionHandler(PasswordResetTokenAlreadyDefined.class)
    public ResponseEntity<BadRequestResponse> handlePasswordResetTokenAlreadyDefined(PasswordResetTokenAlreadyDefined e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }

}
