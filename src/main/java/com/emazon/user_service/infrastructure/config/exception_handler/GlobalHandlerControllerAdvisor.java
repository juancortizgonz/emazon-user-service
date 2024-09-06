package com.emazon.user_service.infrastructure.config.exception_handler;

import com.emazon.user_service.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerControllerAdvisor {
    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleEntityAlreadyExistsException(EntityAlreadyExistsException e) {
        return e.getMessage();
    }

    @ExceptionHandler(DniInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDniInvalidException(DniInvalidException e) {
        return e.getMessage();
    }

    @ExceptionHandler(EmailInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleEmailInvalidException(EmailInvalidException e) {
        return e.getMessage();
    }

    @ExceptionHandler(LegalAgeInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleLegalAgeInvalidException(LegalAgeInvalidException e) {
        return e.getMessage();
    }

    @ExceptionHandler(PhoneInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlePhoneInvalidException(PhoneInvalidException e) {
        return e.getMessage();
    }
}
