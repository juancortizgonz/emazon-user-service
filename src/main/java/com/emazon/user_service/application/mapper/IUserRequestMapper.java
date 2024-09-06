package com.emazon.user_service.application.mapper;

import com.emazon.user_service.application.dto.UserRequest;
import com.emazon.user_service.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {
    @Mapping(source = "birthDate", target = "birthDate", qualifiedByName = "convertStringToLocalDate")
    User toUser(UserRequest userRequest);

    @Named("convertStringToLocalDate")
    default LocalDate convertStringToLocalDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(birthDate, formatter);
    }
}
