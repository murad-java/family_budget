package com.murad.family_budget.security;

import com.murad.family_budget.entity.User;
import com.murad.family_budget.models.Status;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author Murad Salmanov (legenda)
 * @created 01/06/2021 - 20:55
 * @project family_budget
 */
@Data
public class SecurityUser implements UserDetails {

    private final String                       username;
    private final String                       password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean                      isActive;

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
    public static UserDetails fromUser(User user){
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
                                                                      user.getActive().equals(Status.ACTIVE),
                                                                      user.getActive().equals(Status.ACTIVE),
                                                                      user.getActive().equals(Status.ACTIVE),
                                                                      user.getActive().equals(Status.ACTIVE),
                                                                      user.getRole().getAuthority());
    }
}
