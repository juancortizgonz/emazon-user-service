package com.emazon.user_service.domain.exception;

public class PhoneInvalidException extends RuntimeException {
    public PhoneInvalidException(String message) {
        super(message);
    }
}
