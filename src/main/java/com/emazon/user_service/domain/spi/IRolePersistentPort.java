package com.emazon.user_service.domain.spi;

public interface IRolePersistentPort {
    Long getRoleId(String roleName);
}
