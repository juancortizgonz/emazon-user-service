package com.emazon.user_service.domain.util;

import com.emazon.user_service.domain.model.User;

public class UserValidation {
    private UserValidation() {
    }

    private static boolean isNameValid(String name) {
        return name != null && name.length() >= 3 && name.length() <= 50;
    }

    private static boolean isLastNameValid(String lastName) {
        return lastName != null && lastName.length() >= 3 && lastName.length() <= 50;
    }

    private static boolean isEmailValid(String email) {
        return email != null && email.length() <= 70;
    }

    private static boolean isPasswordValid(String password) {
        return password != null && password.length() >= 8 && password.length() <= 50;
    }

    private static boolean isUserRoleValid(String role) {
        return role != null && (role.equals("ADMIN") || role.equals("USER") || role.equals("AUX"));
    }

    public static boolean isUserValid(User user) {
        return isNameValid(user.getUserName())
                && isLastNameValid(user.getUserLastName())
                && isEmailValid(user.getUserEmail())
                && isPasswordValid(user.getUserPassword())
                && isUserRoleValid(user.getUserRole().getRoleName());
    }
}
