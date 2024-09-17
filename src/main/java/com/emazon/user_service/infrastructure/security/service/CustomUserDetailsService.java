package com.emazon.user_service.infrastructure.security.service;

import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.infrastructure.entity.UserEntity;
import com.emazon.user_service.infrastructure.mapper.IUserEntityMapper;
import com.emazon.user_service.infrastructure.repository.IUserRepository;
import com.emazon.user_service.infrastructure.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUserEmail(username);
        if (userEntity.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userEntityMapper.toUser(userEntity.get());
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUserId(id);
        if (userEntity.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userEntityMapper.toUser(userEntity.get());
        return new CustomUserDetails(user);
    }
}
