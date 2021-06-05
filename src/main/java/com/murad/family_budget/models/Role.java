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
    USER(Set.of(Permission.GET_OPERATIONS,
                Permission.IN_MONEY,
                Permission.OUT_MONEY)),

    ADMINISTRATOR(Set.of(Permission.GET_OPERATIONS,
                         Permission.IN_MONEY,
                         Permission.OUT_MONEY,
                         Permission.GET_MY_FAMILY_MEMBERS,
                         Permission.SET_FAMILY_LIMIT,
                         Permission.SET_LIMITS_MY_FAMILY_MEMBER)),

    SUPER_ADMINISTRATOR(Set.of(Permission.GET_OPERATIONS,
                               Permission.IN_MONEY,
                               Permission.OUT_MONEY,
                               Permission.GET_MY_FAMILY_MEMBERS,
                               Permission.SET_FAMILY_LIMIT,
                               Permission.SET_LIMITS_MY_FAMILY_MEMBER,
                               Permission.GET_ANY_FAMILIES_MEMBERS,
                               Permission.SET_LIMITS_ALL_FAMILIES,
                               Permission.SET_LIMITS_ANY_FAMILY_MEMBER,
                               Permission.GET_ALL_FAMILIES));
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
