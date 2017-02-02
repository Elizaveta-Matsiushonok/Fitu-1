package com.linoge.models.converters;

import com.linoge.models.dto.StudentDTO;
import com.linoge.models.entities.Student;

/**
 * Created by Timo on 30.01.2017.
 */
public final class StudentConverter {
    private StudentConverter() {

    }
    /**
     * Convert Student entity to StudentDTO. Static Method.
     * @param student
     * @return StudentDTO
     */
    public static StudentDTO convertStudentToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .fullName(FullNameConverter.convertFullNameToString(student.getFullName()))
                .groupNumber(student.getGroup().getGroupId())
                .organisations(OrganisationConverter.convertOrganisationConverterToDTO(student.getOrganisation()))
                .build();
    }
}
