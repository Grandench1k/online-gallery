package ru.online.gallery.exceptions;

public class UserNotEnabled extends RuntimeException {
    public UserNotEnabled(String message) {
        super(message);
    }
}
