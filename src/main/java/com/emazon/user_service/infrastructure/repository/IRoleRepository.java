package com.emazon.user_service.infrastructure.repository;

import com.emazon.user_service.infrastructure.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query("SELECT r.roleId FROM RoleEntity r WHERE r.name = :roleName")
    Long getRoleIdByName(@Param("roleName") String roleName);
}
