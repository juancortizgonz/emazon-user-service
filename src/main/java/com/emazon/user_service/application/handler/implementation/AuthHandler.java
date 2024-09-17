package com.emazon.user_service.application.handler.implementation;

import com.emazon.user_service.application.dto.auth.AuthRequest;
import com.emazon.user_service.application.dto.auth.AuthResponse;
import com.emazon.user_service.application.handler.IAuthHandler;
import com.emazon.user_service.infrastructure.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandler implements IAuthHandler {
    private final AuthenticationService authenticationService;

    @Override
    public AuthResponse authenticateUser(AuthRequest authRequest) {
        return authenticationService.auth(authRequest);
    }
}
