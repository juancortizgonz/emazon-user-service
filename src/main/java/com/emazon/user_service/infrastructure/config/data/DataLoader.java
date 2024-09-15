package com.emazon.user_service.infrastructure.config.data;

import com.emazon.user_service.domain.model.User;
import com.emazon.user_service.infrastructure.mapper.IUserEntityMapper;
import com.emazon.user_service.infrastructure.repository.IUserRepository;
import com.emazon.user_service.infrastructure.util.DataLoaderConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {
    @Value("${admin.password}")
    private String adminPassword;

    @Bean
    public CommandLineRunner loadData(IUserRepository userRepository, IUserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminEmail = DataLoaderConstants.ADMIN_EMAIL;
            if (userRepository.findByUserEmail(adminEmail).isEmpty()) {
                User user = new User(
                        null,
                        DataLoaderConstants.ADMIN_NAME,
                        DataLoaderConstants.ADMIN_LAST_NAME,
                        DataLoaderConstants.ADMIN_DNI,
                        DataLoaderConstants.ADMIN_PHONE,
                        DataLoaderConstants.ADMIN_BIRTH_DATE,
                        adminEmail,
                        passwordEncoder.encode(adminPassword),
                        DataLoaderConstants.ADMIN_ROLE
                );
                userRepository.save(userEntityMapper.toUserEntity(user));
            }
        };
    }
}
