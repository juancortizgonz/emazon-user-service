package com.emazon.user_service.domain.api.usecase;

import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.exception.UserIsNotValidException;
import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.domain.spi.IUserPersistentPort;
import com.emazon.user_service.domain.util.UserValidation;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistentPort userPersistentPort;
    private final PasswordEncoder passwordEncoder;

    public UserUseCase(IUserPersistentPort userPersistentPort, PasswordEncoder passwordEncoder) {
        this.userPersistentPort = userPersistentPort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        if (!UserValidation.isUserValid(user)) {
            throw new UserIsNotValidException("User is not valid: " + user.getUserId());
        }

        if (userPersistentPort.isUserEmailExist(user.getUserEmail())) {
            throw new UserIsNotValidException("User email already exist: " + user.getUserEmail());
        }

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userPersistentPort.saveUser(user);
    }
}
