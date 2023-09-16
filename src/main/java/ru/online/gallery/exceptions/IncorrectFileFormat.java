package ru.online.gallery.exceptions;

public class IncorrectFileFormat extends RuntimeException {
    public IncorrectFileFormat(String message) {
        super(message);
    }
}
