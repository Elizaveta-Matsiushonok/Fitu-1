package com.linoge.models.converters;

import com.linoge.models.enums.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Timo on 09.01.2017.
 */
@Converter
public class RoleConverter implements AttributeConverter<List<Role>, String> {

    private static final String SEPARATOR = " ";

    @Override
    public String convertToDatabaseColumn(List<Role> roles) {
        return roles.stream()
                .map(role -> role.getAuthority() + SEPARATOR)
                 .collect(Collectors.joining());
    }

    @Override
    public List<Role> convertToEntityAttribute(String rolesWithSeparator) {
        return Arrays.asList(rolesWithSeparator.trim().split(SEPARATOR)).stream()
                        .map(role -> Role.valueOf(role))
                        .collect(Collectors.toList());
    }
}
