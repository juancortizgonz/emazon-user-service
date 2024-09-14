package com.emazon.user_service.infrastructure.mapper;

import com.emazon.user_service.domain.model.Role;
import com.emazon.user_service.infrastructure.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IRoleEntityMapper {
    Role toRole(Optional<RoleEntity> roleEntity);
}
