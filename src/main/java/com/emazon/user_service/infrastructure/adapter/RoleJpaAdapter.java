package com.emazon.user_service.infrastructure.adapter;

import com.emazon.user_service.domain.spi.IRolePersistentPort;
import com.emazon.user_service.infrastructure.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistentPort {
    private final IRoleRepository roleRepository;

    @Override
    public Long getRoleId(String roleName) {
        return roleRepository.getRoleIdByName(roleName);
    }
}
