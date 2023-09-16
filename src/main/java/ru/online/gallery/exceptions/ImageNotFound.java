package ru.online.gallery.exceptions;

public class ImageNotFound extends RuntimeException {
    public ImageNotFound(String message) {
        super(message);
    }
}
