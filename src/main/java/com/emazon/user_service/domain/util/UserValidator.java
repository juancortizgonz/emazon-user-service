package com.emazon.user_service.domain.util;

import com.emazon.user_service.domain.exception.DniInvalidException;
import com.emazon.user_service.domain.exception.EmailInvalidException;
import com.emazon.user_service.domain.exception.LegalAgeInvalidException;
import com.emazon.user_service.domain.exception.PhoneInvalidException;
import com.emazon.user_service.domain.model.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class UserValidator {

    public void validatorManager(User user) {
        validateEmail(user.getEmail());
        validateDni(user.getDni());
        validatePhone(user.getPhone());
        validateLegalAge(user.getBirthDate());
    }

    private void validateLegalAge(LocalDate birthDate) {
        if (birthDate == null || Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            throw new LegalAgeInvalidException("The age must be at least 18 years");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new PhoneInvalidException("The phone number must not be empty");
        }
        if (!Pattern.matches("^\\+57\\d{11}$", phone)) {
            throw new PhoneInvalidException("The phone number must not be empty");
        }
    }

    private void validateDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new DniInvalidException("The DNI must not be empty");
        }
        if (!Pattern.matches("\\D*$", dni)) {
            throw new DniInvalidException("The DNI must not be empty");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new EmailInvalidException("The email must not be empty");
        }
        if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) {
            throw new EmailInvalidException("The email must not be empty");
        }
    }

}
