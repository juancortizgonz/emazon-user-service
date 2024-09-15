package com.emazon.user_service.application.dto.user;

import com.emazon.user_service.application.util.SizeValidationConstants;
import com.emazon.user_service.application.util.ValidationConstantsMessages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = ValidationConstantsMessages.NAME_CANNOT_BE_BLANK)
    @Size(min = SizeValidationConstants.MIN_NAME_SIZE, max = SizeValidationConstants.MAX_NAME_SIZE, message = ValidationConstantsMessages.NAME_SIZE_MESSAGE)
    private String name;

    @NotBlank(message = ValidationConstantsMessages.LAST_NAME_CANNOT_BE_BLANK)
    @Size(min = SizeValidationConstants.MIN_LAST_NAME_SIZE, max = SizeValidationConstants.MAX_LAST_NAME_SIZE, message = ValidationConstantsMessages.LAST_NAME_SIZE_MESSAGE)
    private String lastName;

    @NotBlank(message = ValidationConstantsMessages.DNI_CANNOT_BE_BLANK)
    @Pattern(regexp = ValidationConstantsMessages.DNI_REGEX, message = ValidationConstantsMessages.DNI_REGEX_MESSAGE)
    private String dni;

    @NotBlank(message = ValidationConstantsMessages.PHONE_CANNOT_BE_BLANK)
    @Pattern(regexp = ValidationConstantsMessages.PHONE_REGEX, message = ValidationConstantsMessages.PHONE_REGEX_MESSAGE)
    private String phone;

    @NotNull(message = ValidationConstantsMessages.BIRTH_DATE_CANNOT_BE_BLANK)
    @Past(message = ValidationConstantsMessages.BIRTH_DATE_PAST_MESSAGE)
    private LocalDate birthDate;

    @NotBlank(message = ValidationConstantsMessages.EMAIL_CANNOT_BE_BLANK)
    private String email;

    @NotBlank(message = ValidationConstantsMessages.PASSWORD_CANNOT_BE_BLANK)
    @Size(min = SizeValidationConstants.MIN_PASSWORD_SIZE, max = SizeValidationConstants.MAX_PASSWORD_SIZE, message = ValidationConstantsMessages.PASSWORD_REGEX_MESSAGE)
    @Pattern(regexp = ValidationConstantsMessages.PASSWORD_REGEX, message = ValidationConstantsMessages.PASSWORD_REGEX_MESSAGE)
    private String password;

    @NotBlank(message = ValidationConstantsMessages.ROLE_CANNOT_BE_BLANK)
    private String role;
}
