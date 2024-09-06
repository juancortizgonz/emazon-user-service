package com.emazon.user_service.domain.exception;

public class DniInvalidException extends RuntimeException {
    public DniInvalidException(String message) {
        super(message);
    }
}
