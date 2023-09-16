package ru.online.gallery.exceptions;

public class UserAlreadyDefined extends RuntimeException {
    public UserAlreadyDefined(String message) {
        super(message);
    }
}
