package com.linoge.models.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Timo on 13.01.2017.
 * Convert List of Jobs in entity to database view with Separator and back.
 */
@Converter
public final class JobsConverter implements AttributeConverter<List<String>, String> {

    private final String SEPARATOR = "|";

    public JobsConverter() {
    }

    @Override
    public String convertToDatabaseColumn(List<String> jobs) {
        return jobs.stream()
                .collect(Collectors.joining(SEPARATOR));
    }

    @Override
    public List<String> convertToEntityAttribute(String jobsWithSeparator) {
        return Arrays.stream(jobsWithSeparator.split(Pattern.quote(SEPARATOR)))
                .collect(Collectors.toList());
    }
}
