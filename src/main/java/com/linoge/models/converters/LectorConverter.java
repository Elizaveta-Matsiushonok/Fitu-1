package com.linoge.models.converters;

import com.linoge.models.dto.LectorDTO;
import com.linoge.models.entities.Lector;

import java.util.List;

import static com.linoge.models.converters.FullNameConverter.convertFullNameToString;
import static com.linoge.models.converters.SubjectConverter.convertSubjectCollectionToDTO;
import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 03.02.2017.
 */
public final class LectorConverter {
    private LectorConverter() {
    }

    public static List<LectorDTO> convertLectorCollectionToDTO(List<Lector> lectors) {
        return lectors.stream()
                .map(lector -> LectorDTO.builder()
                        .id(lector.getId())
                        .fullName(convertFullNameToString(lector.getFullName()))
                        .build())
                .collect(toList());
    }

    public static LectorDTO convertLectorToDTO(Lector lector) {
        return LectorDTO.builder()
                .id(lector.getId())
                .fullName(convertFullNameToString(lector.getFullName()))
                .information(lector.getInformation())
                .subjects(convertSubjectCollectionToDTO(lector.getSubjects()))
                .build();
    }
}
