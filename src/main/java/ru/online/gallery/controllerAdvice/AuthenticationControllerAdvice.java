package ru.online.gallery.controllerAdvice;

import org.springframework.http.ResponseEntity;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exceptions.*;

public interface AuthenticationControllerAdvice {

    ResponseEntity<NotFoundResponse> handleNotFound(UserNotFound e);

    ResponseEntity<NotFoundResponse> handleNotFound(UsernameNotFound e);

    ResponseEntity<BadRequestResponse> handleAlreadyDefined(UserAlreadyDefined e);

    ResponseEntity<BadRequestResponse> handleUserNotEnabled(UserNotEnabled e);

    ResponseEntity<BadRequestResponse> handleConfirmationTokenIsExpired(ConfirmationTokenExpired e);
}
