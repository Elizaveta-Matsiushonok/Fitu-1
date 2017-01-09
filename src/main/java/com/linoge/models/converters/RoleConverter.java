package com.linoge.models.converters;

import com.linoge.models.enums.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.*;

/**
 * Created by Timo on 09.01.2017.
 */
@Converter
public class RoleConverter implements AttributeConverter<Set<Role>, String> {

    private static final String SEPARATOR = "|";


    @Override
    public String convertToDatabaseColumn(Set<Role> roles) {
        StringBuilder sb = new StringBuilder();
        roles.forEach(role -> sb.append(role.getAuthority() + SEPARATOR));
        return sb.toString();
    }

    @Override
    public Set<Role> convertToEntityAttribute(String rolesWithSeparator) {
        Set<Role> roles = new HashSet<>();
        List<String> roleText = new ArrayList<>(Arrays.asList(rolesWithSeparator.split(SEPARATOR)));
        roleText.forEach(role -> roles.add(Role.valueOf(role)));
        return roles;
    }
}
