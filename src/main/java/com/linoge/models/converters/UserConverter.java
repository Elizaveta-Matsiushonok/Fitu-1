package com.linoge.models.converters;

import com.linoge.models.dto.UserDTO;
import com.linoge.models.entities.User;

import java.util.stream.Collectors;

/**
 * Created by Tim on 08.01.2017.
 */
public final class UserConverter {

    private UserConverter() {
    }

    public static UserDTO convertUserToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .authorities(user.getAuthorities().stream()
                        .map(Enum::toString)
                        .collect(Collectors.toList())).build();
    }
}
