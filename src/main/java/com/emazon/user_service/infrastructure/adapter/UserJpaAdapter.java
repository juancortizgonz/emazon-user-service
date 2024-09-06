package com.emazon.user_service.infrastructure.adapter;

import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.domain.spi.IUserPersistentPort;
import com.emazon.user_service.infrastructure.mapper.IUserEntityMapper;
import com.emazon.user_service.infrastructure.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistentPort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveAuxUser(User user) {
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
