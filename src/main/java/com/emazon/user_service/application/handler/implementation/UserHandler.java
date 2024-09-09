package com.emazon.user_service.application.handler.implementation;

import com.emazon.user_service.application.dto.UserRequest;
import com.emazon.user_service.application.dto.UserResponse;
import com.emazon.user_service.application.handler.IUserHandler;
import com.emazon.user_service.application.mapper.IUserRequestMapper;
import com.emazon.user_service.application.mapper.IUserResponseMapper;
import com.emazon.user_service.domain.api.IRoleServicePort;
import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.domain.util.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandler implements IUserHandler {
    private final IUserRequestMapper userRequestMapper;
    private final IRoleServicePort roleServicePort;
    private final IUserServicePort userServicePort;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        user.setRoleId(roleServicePort.getRoleId(RoleEnum.AUX.name()));
        userServicePort.saveAuxUser(user);
        return userResponseMapper.toUserResponse(user);
    }
}
