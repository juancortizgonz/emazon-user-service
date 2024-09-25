package com.emazon.user_service.application.dto.auth;

import com.emazon.user_service.application.util.AuthRequestConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = AuthRequestConstants.AUTH_REQUEST_SCHEMA_DESCRIPTION)
public class AuthRequest {
    @Schema(description = AuthRequestConstants.AUTH_REQUEST_EMAIL_DESCRIPTION, example = AuthRequestConstants.AUTH_REQUEST_EMAIL_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = AuthRequestConstants.AUTH_REQUEST_PASSWORD_DESCRIPTION, example = AuthRequestConstants.AUTH_REQUEST_PASSWORD_EXAMPLE, requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
