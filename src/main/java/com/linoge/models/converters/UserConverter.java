package com.linoge.models.converters;

import com.linoge.models.dto.UserDTO;
import com.linoge.models.entities.User;

import static java.util.stream.Collectors.toList;

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
                        .collect(toList()))
                .build();
    }
}
