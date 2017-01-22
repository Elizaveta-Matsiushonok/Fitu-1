package com.linoge.dao;

import com.linoge.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Timo on 13.01.2017.
 */
public interface StudentDAO extends JpaRepository<Student, Long> {
}
