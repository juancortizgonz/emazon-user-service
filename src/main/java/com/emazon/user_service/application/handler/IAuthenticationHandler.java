package com.emazon.user_service.application.handler;

import com.emazon.user_service.application.dto.auth.AuthenticationRequest;
import com.emazon.user_service.application.dto.auth.AuthenticationResponse;

public interface IAuthenticationHandler {
    AuthenticationResponse auth(AuthenticationRequest authenticationRequest);
}
