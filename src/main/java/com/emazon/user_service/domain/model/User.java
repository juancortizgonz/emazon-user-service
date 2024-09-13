package com.emazon.user_service.domain.model;

import com.emazon.user_service.domain.model.builder.UserBuilder;

import java.time.LocalDate;

public class User implements UserBuilder {
    private Long userId;
    private String userName;
    private String userLastName;
    private String userDni;
    private String userPhone;
    private LocalDate userBirthDate;
    private String userEmail;
    private String userPassword;
    private Role userRole;

    public User(Long userId, String userName, String userLastName, String userDni, String userPhone, LocalDate userBirthDate, String userEmail, String userPassword, Role userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userDni = userDni;
        this.userPhone = userPhone;
        this.userBirthDate = userBirthDate;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Override
    public void setUserDni(String userDni) {
        this.userDni = userDni;
    }

    @Override
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public void setUserRole(Role role) {
        this.userRole = role;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserDni() {
        return userDni;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Role getUserRole() {
        return userRole;
    }
}
