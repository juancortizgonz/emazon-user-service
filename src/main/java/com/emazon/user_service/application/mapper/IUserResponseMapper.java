package com.emazon.user_service.application.mapper;

import com.emazon.user_service.application.dto.UserResponse;
import com.emazon.user_service.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserResponseMapper {
    UserResponse toUserResponse(User user);
}
