package com.emazon.user_service.application.dto.user;

import com.emazon.user_service.application.util.SizeValidationConstants;
import com.emazon.user_service.application.util.UserRequestConstants;
import com.emazon.user_service.application.util.ValidationConstantsMessages;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = UserRequestConstants.USER_REQUEST_SCHEMA_DESCRIPTION)
public class UserRequest {
    @Schema(description = UserRequestConstants.USER_REQUEST_NAME_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_NAME_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.NAME_CANNOT_BE_BLANK)
    @Size(min = SizeValidationConstants.MIN_NAME_SIZE, max = SizeValidationConstants.MAX_NAME_SIZE, message = ValidationConstantsMessages.NAME_SIZE_MESSAGE)
    private String name;

    @Schema(description = UserRequestConstants.USER_REQUEST_LAST_NAME_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_LAST_NAME_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.LAST_NAME_CANNOT_BE_BLANK)
    @Size(min = SizeValidationConstants.MIN_LAST_NAME_SIZE, max = SizeValidationConstants.MAX_LAST_NAME_SIZE, message = ValidationConstantsMessages.LAST_NAME_SIZE_MESSAGE)
    private String lastName;

    @Schema(description = UserRequestConstants.USER_REQUEST_DNI_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_DNI_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.DNI_CANNOT_BE_BLANK)
    @Pattern(regexp = ValidationConstantsMessages.DNI_REGEX, message = ValidationConstantsMessages.DNI_REGEX_MESSAGE)
    private String dni;

    @Schema(description = UserRequestConstants.USER_REQUEST_PHONE_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_PHONE_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.PHONE_CANNOT_BE_BLANK)
    @Pattern(regexp = ValidationConstantsMessages.PHONE_REGEX, message = ValidationConstantsMessages.PHONE_REGEX_MESSAGE)
    private String phone;

    @Schema(description = UserRequestConstants.USER_REQUEST_BIRTH_DATE_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_BIRTH_DATE_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = ValidationConstantsMessages.BIRTH_DATE_CANNOT_BE_BLANK)
    @Past(message = ValidationConstantsMessages.BIRTH_DATE_PAST_MESSAGE)
    private LocalDate birthDate;

    @Schema(description = UserRequestConstants.USER_REQUEST_EMAIL_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_EMAIL_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.EMAIL_CANNOT_BE_BLANK)
    private String email;

    @Schema(description = UserRequestConstants.USER_REQUEST_PASSWORD_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_PASSWORD_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.PASSWORD_CANNOT_BE_BLANK)
    @Size(min = SizeValidationConstants.MIN_PASSWORD_SIZE, max = SizeValidationConstants.MAX_PASSWORD_SIZE, message = ValidationConstantsMessages.PASSWORD_REGEX_MESSAGE)
    @Pattern(regexp = ValidationConstantsMessages.PASSWORD_REGEX, message = ValidationConstantsMessages.PASSWORD_REGEX_MESSAGE)
    private String password;

    @Schema(description = UserRequestConstants.USER_REQUEST_ROLE_DESCRIPTION, example = UserRequestConstants.USER_REQUEST_ROLE_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = ValidationConstantsMessages.ROLE_CANNOT_BE_BLANK)
    private String role;
}
