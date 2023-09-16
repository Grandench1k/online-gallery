package ru.online.gallery.exceptions;

public class VideoNotFound extends RuntimeException {
    public VideoNotFound(String message) {
        super(message);
    }
}
