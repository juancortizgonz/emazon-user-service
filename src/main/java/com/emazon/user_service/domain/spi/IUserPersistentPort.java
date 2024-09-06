package com.emazon.user_service.domain.spi;

import com.emazon.user_service.domain.model.User;

public interface IUserPersistentPort {
    void saveAuxUser(User user);
    boolean existsByEmail(String email);
}
