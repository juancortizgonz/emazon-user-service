package com.emazon.user_service.infrastructure.mapper;

import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    @Mapping(target = "userRole", source = "userRole.roleName")
    UserEntity toUserEntity(User user);
}
