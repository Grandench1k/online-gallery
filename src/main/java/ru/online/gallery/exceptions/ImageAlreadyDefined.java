package ru.online.gallery.exceptions;

public class ImageAlreadyDefined extends RuntimeException {
    public ImageAlreadyDefined(String message) {
        super(message);
    }
}
