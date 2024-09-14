package com.emazon.user_service.application.util;

public class ValidationConstantsMessages {
    private ValidationConstantsMessages() {
    }

    public static final String NAME_CANNOT_BE_BLANK = "The name field cannot be blank";
    public static final String LAST_NAME_CANNOT_BE_BLANK = "The description field cannot be blank";
    public static final String DNI_CANNOT_BE_BLANK = "The DNI field cannot be blank";
    public static final String PHONE_CANNOT_BE_BLANK = "The phone field cannot be blank";
    public static final String BIRTH_DATE_CANNOT_BE_BLANK = "The birth date field cannot be blank";
    public static final String EMAIL_CANNOT_BE_BLANK = "The email field cannot be blank";
    public static final String PASSWORD_CANNOT_BE_BLANK = "The password field cannot be blank";
    public static final String ROLE_CANNOT_BE_BLANK = "The role field cannot be blank";

    public static final String NAME_SIZE_MESSAGE = "The name field must be between 3 and 50 characters";
    public static final String LAST_NAME_SIZE_MESSAGE = "The last name field must be between 3 and 50 characters";
    public static final String EMAIL_SIZE_MESSAGE = "The email field must be less than 70 characters";

    public static final String DNI_REGEX_MESSAGE = "The DNI field must be numeric";
    public static final String PHONE_REGEX_MESSAGE = "The phone field must be numeric and start with +57";
    public static final String BIRTH_DATE_REGEX_MESSAGE = "The birth date field must be in the format yyyy-MM-dd";
    public static final String EMAIL_REGEX_MESSAGE = "The email field must be a valid email";
    public static final String PASSWORD_REGEX_MESSAGE = "The password field must contain at least one lowercase letter, one uppercase letter, one number, one special character and be between 8 and 50 characters";
    public static final String ROLE_REGEX_MESSAGE = "The role field must be AUX, ADMIN or USER";
}