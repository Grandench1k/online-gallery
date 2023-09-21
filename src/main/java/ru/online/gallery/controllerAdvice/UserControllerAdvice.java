package ru.online.gallery.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.online.gallery.controller.UserController;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exception.InvalidPassword;
import ru.online.gallery.exception.PasswordsMatch;
import ru.online.gallery.exception.UserImageNotFound;

@RestControllerAdvice(basePackageClasses = UserController.class)
public class UserControllerAdvice {
    @ExceptionHandler(UserImageNotFound.class)
    public ResponseEntity<NotFoundResponse> handleNotFoundUserImage(UserImageNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(e.getMessage()));
    }
    @ExceptionHandler(PasswordsMatch.class)
    public ResponseEntity<BadRequestResponse> handlePasswordsMatch(PasswordsMatch e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }
    @ExceptionHandler(InvalidPassword.class)
    public ResponseEntity<BadRequestResponse> handleInvalidPassword(InvalidPassword e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }
}
