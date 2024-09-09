package com.emazon.user_service.infrastructure.controller;

import com.emazon.user_service.application.dto.UserRequest;
import com.emazon.user_service.application.dto.UserResponse;
import com.emazon.user_service.application.handler.IUserHandler;
import com.emazon.user_service.application.mapper.IUserRequestMapper;
import com.emazon.user_service.application.mapper.IUserResponseMapper;
import com.emazon.user_service.domain.api.IRoleServicePort;
import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.domain.util.RoleEnum;
import com.emazon.user_service.infrastructure.util.UserControllerConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;

    @PostMapping("/assistant")
    @PreAuthorize(UserControllerConstants.IS_ROLE_ADMIN)
    public ResponseEntity<UserResponse> saveAssistant(@RequestBody UserRequest userRequest) {
        UserResponse response = userHandler.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
