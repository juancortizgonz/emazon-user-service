package com.emazon.user_service.domain.model.builder;

import java.time.LocalDate;
import java.util.Set;

public interface UserBuilder {
    void setUserId(Long userId);
    void setUserName(String userName);
    void setUserLastName(String userLastName);
    void setUserDni(String userDni);
    void setUserPhone(String userPhone);
    void setUserBirthDate(LocalDate userBirthDate);
    void setUserEmail(String userEmail);
    void setUserPassword(String userPassword);
    void setUserRole(Set<String> userRole);
}
