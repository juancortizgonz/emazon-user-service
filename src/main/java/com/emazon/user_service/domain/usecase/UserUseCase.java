package com.emazon.user_service.domain.usecase;

import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.exception.EntityAlreadyExistsException;
import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.domain.spi.IUserPersistentPort;
import com.emazon.user_service.domain.util.UserValidator;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistentPort userPersistentPort;
    private final UserValidator userValidator;

    public UserUseCase(IUserPersistentPort userPersistentPort, UserValidator userValidator) {
        this.userPersistentPort = userPersistentPort;
        this.userValidator = userValidator;
    }

    @Override
    public void saveAuxUser(User user) {
        if (userPersistentPort.existsByEmail(user.getEmail())) {
            throw new EntityAlreadyExistsException("The user already exists");
        }
        userValidator.validatorManager(user);
        userPersistentPort.saveAuxUser(user);
    }
}
