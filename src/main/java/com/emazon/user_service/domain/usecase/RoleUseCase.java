package com.emazon.user_service.domain.usecase;

import com.emazon.user_service.domain.api.IRoleServicePort;
import com.emazon.user_service.domain.spi.IRolePersistentPort;
import lombok.RequiredArgsConstructor;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistentPort rolePersistentPort;

    public RoleUseCase(IRolePersistentPort rolePersistentPort) {
        this.rolePersistentPort = rolePersistentPort;
    }

    @Override
    public Long getRoleId(String roleName) {
        return rolePersistentPort.getRoleId(roleName);
    }
}
