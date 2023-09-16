package ru.online.gallery.exceptions;

public class ConfirmationTokenNotFound extends RuntimeException {
    public ConfirmationTokenNotFound(String message) {
        super(message);
    }
}
