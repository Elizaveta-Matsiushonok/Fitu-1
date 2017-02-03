package com.linoge.models.converters;

import com.linoge.models.dto.StudentDTO;
import com.linoge.models.entities.Student;

import static com.linoge.models.converters.FullNameConverter.convertFullNameToString;
import static com.linoge.models.converters.OrganisationConverter.convertOrganisationConverterToDTO;

/**
 * Created by Timo on 30.01.2017.
 */
public final class StudentConverter {
    private StudentConverter() {

    }

    /**
     * Convert Student entity to StudentDTO. Static Method.
     *
     * @param student
     * @return StudentDTO
     */
    public static StudentDTO convertStudentToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .fullName(convertFullNameToString(student.getFullName()))
                .groupNumber(student.getGroup().getGroupId())
                .organisations(convertOrganisationConverterToDTO(student.getOrganisation()))
                .build();
    }
}
