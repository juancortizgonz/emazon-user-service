package com.emazon.user_service.domain.spi;

import com.emazon.user_service.domain.model.Role;

import java.util.Optional;

public interface IRolePersistentPort {
    Optional<Role> getRoleByName(String roleName);
}
