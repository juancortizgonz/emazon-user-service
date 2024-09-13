package com.emazon.user_service.application.dto.user;

import com.emazon.user_service.application.util.ValidationConstantsMessages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3, max = 50, message = ValidationConstantsMessages.NAME_SIZE_MESSAGE)
    private String name;

    @NotBlank(message = ValidationConstantsMessages.LAST_NAME_CANNOT_BE_BLANK)
    @Size(min = 3, max = 50, message = ValidationConstantsMessages.LAST_NAME_SIZE_MESSAGE)
    private String lastName;

    @NotBlank(message = ValidationConstantsMessages.DNI_CANNOT_BE_BLANK)
    @Pattern(regexp = "\\D*$", message = ValidationConstantsMessages.DNI_REGEX_MESSAGE)
    private String dni;

    @NotBlank(message = ValidationConstantsMessages.PHONE_CANNOT_BE_BLANK)
    @Pattern(regexp = "^\\+57\\d{11}$", message = ValidationConstantsMessages.PHONE_REGEX_MESSAGE)
    private String phone;

    @NotBlank(message = ValidationConstantsMessages.BIRTH_DATE_CANNOT_BE_BLANK)
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = ValidationConstantsMessages.BIRTH_DATE_REGEX_MESSAGE)
    private LocalDate birthDate;

    @NotBlank(message = ValidationConstantsMessages.EMAIL_CANNOT_BE_BLANK)
    @Max(value = 70, message = ValidationConstantsMessages.EMAIL_SIZE_MESSAGE)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = ValidationConstantsMessages.EMAIL_REGEX_MESSAGE)
    private String email;

    @NotBlank(message = ValidationConstantsMessages.PASSWORD_CANNOT_BE_BLANK)
    @Size(min = 8, max = 50, message = ValidationConstantsMessages.PASSWORD_REGEX_MESSAGE)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,64}$")
    private String password;

    @NotBlank(message = ValidationConstantsMessages.ROLE_CANNOT_BE_BLANK)
    @Pattern(regexp = "^(?:AUX|ADMIN|USER)$", message = ValidationConstantsMessages.ROLE_REGEX_MESSAGE)
    private String role;
}
