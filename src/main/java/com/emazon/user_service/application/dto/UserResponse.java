package com.emazon.user_service.application.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String dni;
    private String phone;
    private String email;
    private String password;
    private LocalDate birthDate;
}
