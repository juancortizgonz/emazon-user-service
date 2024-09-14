package com.emazon.user_service.domain.api.usecase;

import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.exception.UserIsNotValidException;
import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.domain.spi.IUserPersistentPort;
import com.emazon.user_service.domain.util.UserValidation;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistentPort userPersistentPort;

    public UserUseCase(IUserPersistentPort userPersistentPort) {
        this.userPersistentPort = userPersistentPort;
    }

    @Override
    public void createUser(User user) {
        if (!UserValidation.isUserValid(user)) {
            throw new UserIsNotValidException("User is not valid: " + user.getUserId());
        }
        userPersistentPort.saveUser(user);
    }
}
