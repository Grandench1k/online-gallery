package ru.online.gallery.exceptions;

public class ConfirmationTokenExpired extends RuntimeException {
    public ConfirmationTokenExpired(String message) {
        super(message);
    }
}
