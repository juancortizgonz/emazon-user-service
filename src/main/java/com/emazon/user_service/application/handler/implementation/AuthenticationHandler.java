package com.emazon.user_service.application.handler.implementation;

import com.emazon.user_service.application.dto.auth.AuthenticationRequest;
import com.emazon.user_service.application.dto.auth.AuthenticationResponse;
import com.emazon.user_service.application.handler.IAuthenticationHandler;
import com.emazon.user_service.infrastructure.config.security.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationHandler implements IAuthenticationHandler {
    private final AuthenticationService authenticationService;

    @Override
    public AuthenticationResponse auth(AuthenticationRequest authenticationRequest) {
        return authenticationService.auth(authenticationRequest);
    }
}
