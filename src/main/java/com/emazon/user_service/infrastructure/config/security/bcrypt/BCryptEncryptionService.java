package com.emazon.user_service.infrastructure.config.security.bcrypt;

import com.emazon.user_service.domain.api.IEncryptionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptEncryptionService implements IEncryptionService {
    private final PasswordEncoder passwordEncoder;

    public BCryptEncryptionService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encodePlainPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }
}
