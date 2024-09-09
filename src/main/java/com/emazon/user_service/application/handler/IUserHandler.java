package com.emazon.user_service.application.handler;

import com.emazon.user_service.application.dto.UserRequest;
import com.emazon.user_service.application.dto.UserResponse;

public interface IUserHandler {
    UserResponse saveUser(UserRequest userRequest);
}
