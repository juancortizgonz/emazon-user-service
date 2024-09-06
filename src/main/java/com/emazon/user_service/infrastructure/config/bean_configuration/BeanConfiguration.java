package com.emazon.user_service.infrastructure.config.bean_configuration;

import com.emazon.user_service.domain.api.IRoleServicePort;
import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.spi.IRolePersistentPort;
import com.emazon.user_service.domain.spi.IUserPersistentPort;
import com.emazon.user_service.domain.usecase.RoleUseCase;
import com.emazon.user_service.domain.usecase.UserUseCase;
import com.emazon.user_service.domain.util.UserValidator;
import com.emazon.user_service.infrastructure.adapter.RoleJpaAdapter;
import com.emazon.user_service.infrastructure.adapter.UserJpaAdapter;
import com.emazon.user_service.infrastructure.mapper.IUserEntityMapper;
import com.emazon.user_service.infrastructure.repository.IRoleRepository;
import com.emazon.user_service.infrastructure.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;

    @Bean
    public IUserPersistentPort userPersistentPort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public UserValidator userValidator() {
        return new UserValidator();
    }

    @Bean
    public IRolePersistentPort rolePersistentPort() {
        return new RoleJpaAdapter(roleRepository);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistentPort());
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistentPort(), userValidator());
    }
}
