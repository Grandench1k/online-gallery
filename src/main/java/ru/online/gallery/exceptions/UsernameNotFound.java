package ru.online.gallery.exceptions;

public class UsernameNotFound extends RuntimeException {
    public UsernameNotFound(String message) {
        super(message);
    }
}
