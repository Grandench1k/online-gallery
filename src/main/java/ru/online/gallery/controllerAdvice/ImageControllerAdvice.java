package ru.online.gallery.controllerAdvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exceptions.ImageAlreadyDefined;
import ru.online.gallery.exceptions.ImageNotFound;


public interface ImageControllerAdvice {
    @ExceptionHandler(ImageNotFound.class)
    ResponseEntity<NotFoundResponse> handleNotFoundImage(ImageNotFound e);

    @ExceptionHandler(ImageAlreadyDefined.class)
    ResponseEntity<BadRequestResponse> handleAlreadyDefinedImage(ImageAlreadyDefined e);

}
