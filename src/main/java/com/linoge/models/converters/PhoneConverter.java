package com.linoge.models.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timo on 12.01.2017.
 */
@Converter
public final class PhoneConverter implements AttributeConverter<List<String>, String> {

    private final String SEPARATOR = " ";

    private PhoneConverter() {
    }

    @Override
    public String convertToDatabaseColumn(List<String> phones) {
        return phones.stream()
                .map(phone -> phone + SEPARATOR)
                .collect(Collectors.joining());
    }

    @Override
    public List<String> convertToEntityAttribute(String phonesWithSeparator) {
        return Arrays.stream(phonesWithSeparator.trim().split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
