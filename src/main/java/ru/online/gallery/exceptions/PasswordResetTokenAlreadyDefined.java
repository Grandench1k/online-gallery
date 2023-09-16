package ru.online.gallery.exceptions;

public class PasswordResetTokenAlreadyDefined extends RuntimeException {
    public PasswordResetTokenAlreadyDefined(String message) {
        super(message);
    }
}
