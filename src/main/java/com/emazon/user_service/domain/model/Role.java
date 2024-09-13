package com.emazon.user_service.domain.model;

import com.emazon.user_service.domain.model.builder.RoleBuilder;

public class Role implements RoleBuilder {
    private Long roleId;
    private String roleName;
    private String roleDescription;

    public Role(Long roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    @Override
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }
}
