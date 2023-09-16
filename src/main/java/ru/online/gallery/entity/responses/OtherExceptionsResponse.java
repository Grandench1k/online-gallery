package ru.online.gallery.entity.responses;

import java.time.ZonedDateTime;


public record OtherExceptionsResponse(ZonedDateTime timestamp, int status, String message) {
}
