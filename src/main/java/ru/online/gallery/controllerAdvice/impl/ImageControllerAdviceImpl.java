package ru.online.gallery.controllerAdvice.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.online.gallery.controller.ImageController;
import ru.online.gallery.controllerAdvice.ImageControllerAdvice;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exceptions.ImageAlreadyDefined;
import ru.online.gallery.exceptions.ImageNotFound;

@RestControllerAdvice(basePackageClasses = ImageController.class)
public class ImageControllerAdviceImpl implements ImageControllerAdvice {
    @ExceptionHandler(ImageNotFound.class)
    public ResponseEntity<NotFoundResponse> handleNotFoundImage(ImageNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(e.getMessage()));
    }

    @ExceptionHandler(ImageAlreadyDefined.class)
    public ResponseEntity<BadRequestResponse> handleAlreadyDefinedImage(ImageAlreadyDefined e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }


}
