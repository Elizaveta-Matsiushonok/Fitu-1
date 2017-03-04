package com.linoge.servicies.implementations;

import com.linoge.dao.StudentDAO;
import com.linoge.models.entities.Student;
import com.linoge.models.entities.User;
import com.linoge.servicies.StudentService;
import com.linoge.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Timo on 31.01.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public Student findStudentByUserId(Long id) {
        return studentDAO.findByUserId(id);
    }
}
