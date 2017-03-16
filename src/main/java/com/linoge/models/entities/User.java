package com.linoge.models.entities;

import com.linoge.models.converters.RoleConverter;
import com.linoge.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tim on 08.01.2017.
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked;

    @Column(name = "authorities", nullable = false)
    @Convert(converter = RoleConverter.class)
    private List<Role> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
