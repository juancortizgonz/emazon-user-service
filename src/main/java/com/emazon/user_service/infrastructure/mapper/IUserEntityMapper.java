package com.emazon.user_service.infrastructure.mapper;

import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.infrastructure.entity.RoleEntity;
import com.emazon.user_service.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    @Mapping(source = "roleId", target = "role")
    UserEntity toUserEntity(User user);

    default RoleEntity mapRoleEntity(Long roleId) {
        if (roleId == null) return null;
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(roleId);
        return roleEntity;
    }
}
