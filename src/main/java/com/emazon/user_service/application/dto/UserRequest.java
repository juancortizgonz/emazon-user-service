package com.emazon.user_service.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {
    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 50, message = "First name length cannot be empty or exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 1, max = 50, message = "Last name length cannot be empty or exceed 50 characters")
    private String lastName;

    @NotBlank(message = "DNI is required")
    @Pattern(regexp = "\\D*$", message = "DNI must be numeric only")
    private String dni;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+57\\d{11}$", message = "The phone number must be a valid Colombian number")
    private String phone;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "The email must be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 64, message = "Password length must be between 8 and 64 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,64}$", message = "The password must contain at least one special character and a uppercase letter")
    private String password;

    @NotBlank(message = "Birth date is required")
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "Birth date must be valid")
    private LocalDate birthDate;
}
