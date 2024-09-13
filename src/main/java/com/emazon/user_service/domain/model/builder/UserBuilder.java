package com.emazon.user_service.domain.model.builder;

import com.emazon.user_service.domain.model.Role;

import java.time.LocalDate;

public interface UserBuilder {
    void setUserId(Long userId);
    void setUserName(String userName);
    void setUserLastName(String userLastName);
    void setUserDni(String userDni);
    void setUserPhone(String userPhone);
    void setUserBirthDate(LocalDate userBirthDate);
    void setUserEmail(String userEmail);
    void setUserPassword(String userPassword);
    void setUserRole(Role role);
}
