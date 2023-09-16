package ru.online.gallery.exceptions;

public class VideoAlreadyDefined extends RuntimeException {
    public VideoAlreadyDefined(String message) {
        super(message);
    }
}
