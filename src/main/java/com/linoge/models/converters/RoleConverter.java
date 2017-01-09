package com.linoge.models.converters;

import com.linoge.models.enums.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.*;

/**
 * Created by Timo on 09.01.2017.
 */
@Converter
public class RoleConverter implements AttributeConverter<List<Role>, String> {

    private static final String SEPARATOR = " ";


    @Override
    public String convertToDatabaseColumn(List<Role> roles) {
        StringBuilder sb = new StringBuilder();
        roles.forEach(role -> sb.append(role.getAuthority() + SEPARATOR));
        return sb.toString();
    }

    @Override
    public List<Role> convertToEntityAttribute(String rolesWithSeparator) {
        List<Role> roles = new ArrayList<>();
        List<String> listRoles = new ArrayList<>(
                Arrays.asList(rolesWithSeparator.trim().split(SEPARATOR)));
        listRoles.forEach(role -> roles.add(Role.valueOf(role)));
        return roles;
    }
}
