package com.emazon.user_service.domain.exception;

public class UserIsNotValidException extends RuntimeException {
    public UserIsNotValidException(String message) {
        super(message);
    }
}
