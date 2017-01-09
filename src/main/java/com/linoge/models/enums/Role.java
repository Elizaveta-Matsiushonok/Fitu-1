package com.linoge.models.enums;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

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
