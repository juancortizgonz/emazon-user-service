package com.emazon.user_service.domain.api.usecase;

import com.emazon.user_service.domain.api.IRoleServicePort;
import com.emazon.user_service.domain.exception.RoleNotFoundException;
import com.emazon.user_service.domain.model.Role;
import com.emazon.user_service.domain.spi.IRolePersistentPort;

import java.util.Optional;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistentPort rolePersistentPort;

    public RoleUseCase(IRolePersistentPort rolePersistentPort) {
        this.rolePersistentPort = rolePersistentPort;
    }

    @Override
    public Role getRoleByName(String roleName) {
        Optional<Role> result = rolePersistentPort.getRoleByName(roleName);
        if (result.isEmpty()) {
            throw new RoleNotFoundException("Role not found in the database: " + roleName);
        }
        return result.get();
    }
}
