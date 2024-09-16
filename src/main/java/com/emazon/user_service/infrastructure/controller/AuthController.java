package com.emazon.user_service.infrastructure.controller;

import com.emazon.user_service.application.dto.auth.AuthRequest;
import com.emazon.user_service.application.dto.auth.AuthResponse;
import com.emazon.user_service.infrastructure.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authenticationService.auth(authRequest);
    }
}
