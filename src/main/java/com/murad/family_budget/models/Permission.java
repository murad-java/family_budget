package com.murad.family_budget.models;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 17:14
 * @project family_budget
 */
public enum  Permission {
    GET_OPERATIONS("family:get_operations"),
    GET_MY_FAMILY_MEMBERS("family:get_my_members"),
    GET_ANY_FAMILIES_MEMBERS("families:get_any_members"),
    GET_ALL_FAMILIES("families:get_all_families"),
    SET_FAMILY_LIMIT("family:family_limit"),
    SET_LIMITS_ALL_FAMILIES("families:limit_all_familis"),
    SET_LIMITS_MY_FAMILY_MEMBER("family:set_limit_member"),
    SET_LIMITS_ANY_FAMILY_MEMBER("family:set_limit_ANY_member"),
    IN_MONEY("family:in_money"),
    OUT_MONEY("family:out_money");
    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
