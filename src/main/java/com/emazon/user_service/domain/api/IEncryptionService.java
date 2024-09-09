package com.emazon.user_service.domain.api;

public interface IEncryptionService {
    String encodePlainPassword(String plainPassword);
}
