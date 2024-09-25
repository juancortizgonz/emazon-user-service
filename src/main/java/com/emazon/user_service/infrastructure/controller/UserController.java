package com.emazon.user_service.infrastructure.controller;

import com.emazon.user_service.application.dto.user.UserRequest;
import com.emazon.user_service.application.dto.user.UserResponse;
import com.emazon.user_service.application.handler.IUserHandler;
import com.emazon.user_service.infrastructure.util.docs.UserControllerConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler userHandler;

    @Operation(summary = UserControllerConstants.OPERATION_SUMMARY)
    @ApiResponses(value = {
            @ApiResponse(responseCode = UserControllerConstants.CREATED_API_RESPONSE_CODE, description = UserControllerConstants.CREATED_API_RESPONSE_MESSAGE),
            @ApiResponse(responseCode = UserControllerConstants.BAD_REQUEST_API_RESPONSE_CODE, description = UserControllerConstants.BAD_REQUEST_API_RESPONSE_MESSAGE)
    })
    @PostMapping("/aux")
    @Secured(UserControllerConstants.ADMIN_USER_ROLE)
    public ResponseEntity<UserResponse> createAuxUser(@Valid @RequestBody UserRequest userRequest) {
        userHandler.createAuxUser(userRequest);
        return ResponseEntity.ok(new UserResponse(userRequest.getEmail(), userRequest.getRole()));
    }
}
