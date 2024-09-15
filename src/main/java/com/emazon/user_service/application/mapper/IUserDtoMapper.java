package com.emazon.user_service.application.mapper;

import com.emazon.user_service.application.dto.user.UserRequest;
import com.emazon.user_service.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface IUserDtoMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "userLastName", source = "lastName")
    @Mapping(target = "userDni", source = "dni")
    @Mapping(target = "userPhone", source = "phone")
    @Mapping(target = "userBirthDate", source = "birthDate")
    @Mapping(target = "userEmail", source = "email")
    @Mapping(target = "userPassword", source = "password")
    @Mapping(target = "userRole", source = "role", qualifiedByName = "roleToSetRole")
    User toUser(UserRequest userRequest);

    @Named("roleToSetRole")
    default Set<String> roleToSetRole(String role){
        return Set.of(role);
    }
}
