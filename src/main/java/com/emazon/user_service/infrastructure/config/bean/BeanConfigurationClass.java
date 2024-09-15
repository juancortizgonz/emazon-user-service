package com.emazon.user_service.infrastructure.config.bean;

import com.emazon.user_service.domain.api.IUserServicePort;
import com.emazon.user_service.domain.api.usecase.UserUseCase;
import com.emazon.user_service.domain.spi.IUserPersistentPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationClass {
    @Bean
    public IUserServicePort userServicePort(IUserPersistentPort userPersistentPort) {
        return new UserUseCase(userPersistentPort);
    }
}
