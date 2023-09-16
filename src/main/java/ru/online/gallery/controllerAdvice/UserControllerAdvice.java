package ru.online.gallery.controllerAdvice;

import org.springframework.http.ResponseEntity;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exceptions.PasswordsMatch;
import ru.online.gallery.exceptions.UserImageNotFound;

public interface UserControllerAdvice {
    ResponseEntity<NotFoundResponse> handleNotFoundUserImage(UserImageNotFound e);

    ResponseEntity<BadRequestResponse> handlePasswordsMatch(PasswordsMatch e);
}
