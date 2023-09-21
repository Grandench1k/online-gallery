package ru.online.gallery.exception;

public class VideoNotFound extends RuntimeException {
    public VideoNotFound(String message) {
        super(message);
    }
}
