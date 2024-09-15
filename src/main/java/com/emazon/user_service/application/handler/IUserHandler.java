package com.emazon.user_service.application.handler;

import com.emazon.user_service.application.dto.user.UserRequest;

public interface IUserHandler {
    void createAuxUser(UserRequest userRequest);
}
