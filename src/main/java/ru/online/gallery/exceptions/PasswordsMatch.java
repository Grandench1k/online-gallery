package ru.online.gallery.exceptions;

public class PasswordsMatch extends RuntimeException {
    public PasswordsMatch(String message) {
        super(message);
    }
}

