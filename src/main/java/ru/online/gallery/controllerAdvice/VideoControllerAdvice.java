package ru.online.gallery.controllerAdvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exceptions.VideoAlreadyDefined;
import ru.online.gallery.exceptions.VideoNotFound;

public interface VideoControllerAdvice {
    @ExceptionHandler(VideoNotFound.class)
    ResponseEntity<NotFoundResponse> handleNotFoundVideo(VideoNotFound e);

    @ExceptionHandler(VideoAlreadyDefined.class)
    ResponseEntity<BadRequestResponse> handleAlreadyDefinedVideo(VideoAlreadyDefined e);

}
