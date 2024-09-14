package com.emazon.user_service.domain.api;

import com.emazon.user_service.domain.model.Role;

public interface IRoleServicePort {
    Role getRoleByName(String roleName);
}
