package com.linoge.models.converters;

import com.linoge.models.dto.StudentDTO;
import com.linoge.models.entities.Student;

import static com.linoge.models.converters.FullNameConverter.convertFullNameToString;
import static com.linoge.models.converters.OrganisationConverter.convertOrganisationCollectionToDTO;

/**
 * Created by Timo on 30.01.2017.
 */
public final class StudentConverter {
    private static final String BUDGET = "бюджет";
    private static final String PAID = "платная";
    private static final String DAY = "дневная";
    private static final String EVENING = "вечерняя";
    private static final String FIRST = "первое";
    private static final String SECOND = "второе";
    private StudentConverter() {
    }

    /**
     * Convert Student entity to StudentDTO. Static Method.
     *
     * @param student
     * @return StudentDTO
     */
    public static StudentDTO convertStudentToDTO(Student student) {
        String basis = student.getBasis().ordinal() == 0 ? BUDGET : PAID;
        String number = student.getNumber().ordinal() == 0 ? FIRST : SECOND;
        String time = student.getTime().ordinal() == 0 ? DAY : EVENING;

        return StudentDTO.builder()
                .id(student.getId())
                .fullName(convertFullNameToString(student.getFullName()))
                .groupNumber(student.getGroup().getGroupNumber())
                .organisations(convertOrganisationCollectionToDTO(student.getOrganisation()))
                .basis(basis)
                .number(number)
                .time(time)
                .build();
    }
}
