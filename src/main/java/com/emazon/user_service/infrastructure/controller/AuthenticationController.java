package com.emazon.user_service.infrastructure.controller;

import com.emazon.user_service.application.dto.auth.AuthenticationRequest;
import com.emazon.user_service.application.dto.auth.AuthenticationResponse;
import com.emazon.user_service.application.handler.IAuthenticationHandler;
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
public class AuthenticationController {
    private final IAuthenticationHandler authenticationHandler;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> auth(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse response = authenticationHandler.auth(authenticationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
