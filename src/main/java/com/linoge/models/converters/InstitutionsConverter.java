package com.linoge.models.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Timo on 13.01.2017.
 */
@Converter
public final class InstitutionsConverter implements AttributeConverter<List<String>, String> {

    private final String SEPARATOR = "|";

    @Override
    public String convertToDatabaseColumn(List<String> institutions) {
        return institutions.stream()
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public List<String> convertToEntityAttribute(String institutionsWithSeparator) {
        return Arrays.stream(institutionsWithSeparator.split(Pattern.quote(SEPARATOR)))
                .collect(Collectors.toList());
    }
}
