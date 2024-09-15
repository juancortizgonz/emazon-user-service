package com.emazon.user_service.application.handler.implementation;

import com.emazon.user_service.application.dto.user.UserRequest;
import com.emazon.user_service.application.handler.IUserHandler;
import com.emazon.user_service.application.mapper.IUserDtoMapper;
import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.exception.InvalidUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserDtoMapper userDtoMapper;

    Logger logger = Logger.getLogger(UserHandler.class.getName());

    @Override
    public void createAuxUser(UserRequest userRequest) {
        if (!Objects.equals(userRequest.getRole(), "AUX")) {
            throw new InvalidUserRole("Invalid user role: " + userRequest.getRole());
        }
        userServicePort.createUser(userDtoMapper.toUser(userRequest));
    }
}
