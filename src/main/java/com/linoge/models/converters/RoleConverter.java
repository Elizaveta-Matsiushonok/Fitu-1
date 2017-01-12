package com.linoge.models.converters;

import com.linoge.models.enums.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timo on 09.01.2017.
 */
@Converter
public final class RoleConverter implements AttributeConverter<List<Role>, String> {

    private final String SEPARATOR = " ";

    private RoleConverter() {
    }

    @Override
    public String convertToDatabaseColumn(List<Role> roles) {
        return roles.stream()
                .map(role -> role.getAuthority() + SEPARATOR)
                .collect(Collectors.joining());
    }

    @Override
    public List<Role> convertToEntityAttribute(String rolesWithSeparator) {
        return Arrays.stream(rolesWithSeparator.trim().split(SEPARATOR))
                .map(Role::valueOf)
                .collect(Collectors.toList());
    }
}
