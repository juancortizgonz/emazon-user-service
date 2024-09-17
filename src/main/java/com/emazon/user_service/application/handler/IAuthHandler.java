package com.emazon.user_service.application.handler;

import com.emazon.user_service.application.dto.auth.AuthRequest;
import com.emazon.user_service.application.dto.auth.AuthResponse;

public interface IAuthHandler {
    AuthResponse authenticateUser(AuthRequest authRequest);
}
