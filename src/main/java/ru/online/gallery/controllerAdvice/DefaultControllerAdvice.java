package ru.online.gallery.controllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.InvalidContentTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import ru.online.gallery.entity.responses.OtherExceptionsResponse;
import ru.online.gallery.entity.responses.BadRequestResponse;

public interface DefaultControllerAdvice {
    ResponseEntity<BadRequestResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) throws JsonProcessingException;

    ResponseEntity<BadRequestResponse> handleNullPointerException(NullPointerException e);

    ResponseEntity<OtherExceptionsResponse> handleInvalidContentTypeException(InvalidContentTypeException e);

    ResponseEntity<OtherExceptionsResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e);

    ResponseEntity<BadRequestResponse> handleMissingServletRequestPartException(MissingServletRequestPartException e);

    ResponseEntity<BadRequestResponse> handleFileSizeLimitExceededException(FileSizeLimitExceededException e);

    ResponseEntity<BadRequestResponse> handleMessagingException();
}
