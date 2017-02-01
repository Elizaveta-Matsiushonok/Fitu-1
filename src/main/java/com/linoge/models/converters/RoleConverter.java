package com.linoge.models.converters;

import com.linoge.models.enums.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Timo on 09.01.2017.
 */
@Converter
public final class RoleConverter implements AttributeConverter<List<Role>, String> {

    private final String SEPARATOR = "|";

    @Override
    public String convertToDatabaseColumn(List<Role> roles) {
        return roles.stream()
                .map(Role::getAuthority)
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public List<Role> convertToEntityAttribute(String rolesWithSeparator) {
        return Arrays.stream(rolesWithSeparator.split(Pattern.quote(SEPARATOR)))
                .map(Role::valueOf)
                .collect(Collectors.toList());
    }
}
