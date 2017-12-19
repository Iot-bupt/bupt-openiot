package com.bupt.openiot.service.security.model;

import com.bupt.openiot.common.data.User;
import com.bupt.openiot.common.data.id.UserId;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecurityUser extends User {

    private static final long serialVersionUID = -797397440703066079L;

    private Collection<GrantedAuthority> authorities;
    private boolean enabled;

    public SecurityUser() {
        super();
    }

    public SecurityUser(UserId id) {
        super(id);
    }

    public SecurityUser(User user, boolean enabled) {
        super(user);
        this.enabled = enabled;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = Stream.of(SecurityUser.this.getAuthority())
                    .map(authority -> new SimpleGrantedAuthority(authority.name()))
                    .collect(Collectors.toList());
        }
        return authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
