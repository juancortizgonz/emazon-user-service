package com.emazon.user_service.infrastructure.controller;

import com.emazon.user_service.application.dto.auth.AuthRequest;
import com.emazon.user_service.application.dto.auth.AuthResponse;
import com.emazon.user_service.application.handler.IAuthHandler;
import com.emazon.user_service.infrastructure.util.docs.AuthControllerConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthHandler authHandler;

    @Operation(summary = AuthControllerConstants.AUTH_CONTROLLER_CLASS_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = AuthControllerConstants.SUCCESS_LOGIN_CODE, description = AuthControllerConstants.SUCCESS_LOGIN_DESCRIPTION),
            @ApiResponse(responseCode = AuthControllerConstants.INVALID_CREDENTIALS_CODE, description = AuthControllerConstants.INVALID_CREDENTIALS_DESCRIPTION)
    })
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authHandler.authenticateUser(authRequest);
        return ResponseEntity.status(HttpStatus.OK).body(authResponse);
    }
}
