package com.linoge.servicies;

import com.linoge.models.entities.Student;
import com.linoge.models.entities.User;

/**
 * Created by Timo on 31.01.2017.
 */
public interface StudentService{
    Student findStudentByUserId(Long id);
}
