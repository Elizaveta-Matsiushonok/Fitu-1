package com.linoge.servicies;

import com.linoge.models.dto.StudentDTO;
import com.linoge.models.entities.Student;

/**
 * Created by Timo on 31.01.2017.
 */
public interface StudentService{
    Student findStudentByUserId(Long id);

    void requestOrder(Long id);

    Long createStudentFromDTO(StudentDTO studentDTO);
}
