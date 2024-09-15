package com.emazon.user_service.domain.exception;

public class InvalidUserRole extends RuntimeException {
    public InvalidUserRole(String message) {
        super(message);
    }
}
