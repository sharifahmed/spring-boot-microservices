package com.spring.boot.starter.app.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author sharif.ahmed
 * @since 3/25/19
 */
@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ExceptionResponse response = new ExceptionResponse(httpStatus.value(),
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionResponse response = new ExceptionResponse(httpStatus.value(), ex.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }
}
