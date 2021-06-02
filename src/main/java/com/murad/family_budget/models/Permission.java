package com.murad.family_budget.models;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 17:14
 * @project family_budget
 */
public enum  Permission {
    FAMILY_READ("family:read"),
    SET_LIMIT("family:write_limit"),
    SET_ALL_FAMYLI_LIMIT("all_family:write_limit"),
    IN_MONEY("family:in_money"),
    OUT_MONEY("family:out_mony");
    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
