package com.murad.family_budget.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 1:29
 * @project family_budget
 */
public enum Role {
    USER(Set.of(Permission.FAMILY_READ, Permission.IN_MONEY, Permission.OUT_MONEY)),
    ADMINISTRATOR(Set.of(Permission.FAMILY_READ, Permission.IN_MONEY, Permission.OUT_MONEY, Permission.SET_LIMIT)),
    SUPER_ADMINISTRATOR(Set.of(Permission.FAMILY_READ, Permission.IN_MONEY, Permission.OUT_MONEY, Permission.SET_LIMIT, Permission.SET_ALL_FAMYLI_LIMIT));
    private Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority() {
        return getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
