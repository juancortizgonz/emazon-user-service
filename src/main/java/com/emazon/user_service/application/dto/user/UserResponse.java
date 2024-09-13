package com.emazon.user_service.application.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String userEmail;
    private String userRole;
}
