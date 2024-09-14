package com.emazon.user_service.infrastructure.adapter;

import com.emazon.user_service.domain.model.Role;
import com.emazon.user_service.domain.spi.IRolePersistentPort;
import com.emazon.user_service.infrastructure.mapper.IRoleEntityMapper;
import com.emazon.user_service.infrastructure.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistentPort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        return Optional.ofNullable(roleEntityMapper.toRole(roleRepository.findByRoleName(roleName)));
    }
}
