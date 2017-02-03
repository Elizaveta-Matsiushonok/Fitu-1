package com.linoge.models.converters;

import com.linoge.models.dto.SubjectDTO;
import com.linoge.models.entities.Subject;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 03.02.2017.
 */
public final class SubjectConverter {
    private SubjectConverter() {
    }

    public static List<SubjectDTO> convertSubjectCollectionToDTO(List<Subject> subjects) {
        return subjects.stream()
                .map(subject -> SubjectDTO.builder()
                        .id(subject.getId())
                        .description(subject.getDescription())
                        .build())
                .collect(toList());
    }
}
