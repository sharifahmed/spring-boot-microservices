package com.spring.boot.starter.app.rest.exception;

/**
 * @author sharif.ahmed
 * @since 3/25/19
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
