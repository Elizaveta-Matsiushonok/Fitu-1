package com.linoge.models.converters;

import com.linoge.models.shared.FullName;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timo on 11.01.2017.
 * Convert FullName object in entity to database view with Separator and back.
 */
@Converter
public final class FullNameConverter implements AttributeConverter<FullName, String> {

    private final String SEPARATOR = "|";
    private final int SURNAME_INDEX = 0;
    private final int FIRSTNAME_INDEX = 1;
    private final int PATRONYMIC_INDEX = 2;

    public FullNameConverter() {
    }

    @Override
    public String convertToDatabaseColumn(FullName fullName) {
        return fullName.getSurName() + SEPARATOR + fullName.getFirstName() + SEPARATOR + fullName.getPatronymic();
    }

    @Override
    public FullName convertToEntityAttribute(String fullNameWithSeparator) {
        return toFullName(Arrays.stream(fullNameWithSeparator.split(SEPARATOR))
                .collect(Collectors.toList()));


    }

    private FullName toFullName(List<String> fullNameData) {
        return FullName.builder()
                .surName(fullNameData.get(SURNAME_INDEX))
                .firstName(fullNameData.get(FIRSTNAME_INDEX))
                .patronymic(fullNameData.get(PATRONYMIC_INDEX))
                .build();
    }
}
