package ru.online.gallery.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.online.gallery.controller.ImageController;
import ru.online.gallery.entity.responses.BadRequestResponse;
import ru.online.gallery.entity.responses.NotFoundResponse;
import ru.online.gallery.exception.ImageAlreadyDefined;
import ru.online.gallery.exception.ImageNotFound;

@RestControllerAdvice(basePackageClasses = ImageController.class)
public class ImageControllerAdvice {
    @ExceptionHandler(ImageNotFound.class)
    public ResponseEntity<NotFoundResponse> handleNotFoundImage(ImageNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(e.getMessage()));
    }

    @ExceptionHandler(ImageAlreadyDefined.class)
    public ResponseEntity<BadRequestResponse> handleAlreadyDefinedImage(ImageAlreadyDefined e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestResponse(e.getMessage()));
    }


}
