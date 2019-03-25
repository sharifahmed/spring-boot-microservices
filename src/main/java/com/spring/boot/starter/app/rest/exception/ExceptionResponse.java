package com.spring.boot.starter.app.rest.exception;

/**
 * @author sharif.ahmed
 * @since 3/25/19
 */
public class ExceptionResponse {

    private int code;
    private String message;

    public ExceptionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
