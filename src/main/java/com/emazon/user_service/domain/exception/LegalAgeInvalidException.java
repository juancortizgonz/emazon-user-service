package com.emazon.user_service.domain.exception;

public class LegalAgeInvalidException extends RuntimeException {
    public LegalAgeInvalidException(String message) {
        super(message);
    }
}
