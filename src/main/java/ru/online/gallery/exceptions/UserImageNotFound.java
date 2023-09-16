package ru.online.gallery.exceptions;

public class UserImageNotFound extends RuntimeException {
    public UserImageNotFound(String message) {
        super(message);
    }
}
