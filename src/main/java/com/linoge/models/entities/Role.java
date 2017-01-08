package com.linoge.models.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Tim on 08.01.2017.
 */
public enum Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
