package ru.online.gallery.exception;

public class ConfirmationTokenNotFound extends RuntimeException {
    public ConfirmationTokenNotFound(String message) {
        super(message);
    }
}
