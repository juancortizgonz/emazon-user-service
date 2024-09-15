package com.emazon.user_service.infrastructure.controller;

import com.emazon.user_service.application.dto.user.UserRequest;
import com.emazon.user_service.application.dto.user.UserResponse;
import com.emazon.user_service.application.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;

    @PostMapping("/aux")
    public ResponseEntity<UserResponse> createAuxUser(@Valid @RequestBody UserRequest userRequest) {
        userHandler.createAuxUser(userRequest);
        return ResponseEntity.ok(new UserResponse(userRequest.getEmail(), userRequest.getRole()));
    }
}
