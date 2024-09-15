package com.emazon.user_service.infrastructure.mapper;

import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.infrastructure.entity.UserEntity;
import com.emazon.user_service.infrastructure.entity.enums.RoleEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    @Mapping(target = "userRole", source = "userRole", qualifiedByName = "roleSetToString")
    UserEntity toUserEntity(User user);

    @Mapping(target = "userRole", source = "userRole", qualifiedByName = "roleToSetString")
    User toUser(UserEntity userEntity);

    @Named("roleSetToString")
    default RoleEnum roleSetToString(Set<String> userRole) {
        return RoleEnum.valueOf(userRole.iterator().next());
    }

    @Named("roleToSetString")
    default Set<String> roleToSetString(RoleEnum userRole) {
        return Set.of(userRole.name());
    }
}
