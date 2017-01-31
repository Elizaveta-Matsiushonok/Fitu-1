package com.linoge.dao;

import com.linoge.models.entities.Student;
import com.linoge.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Timo on 13.01.2017.
 */
public interface StudentDAO extends JpaRepository<Student, Long> {
    Student findByUser(User user);
    Student findByUserId(Long id);
}
