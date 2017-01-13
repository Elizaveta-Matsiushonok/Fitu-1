package com.linoge.repositories;

import com.linoge.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Timo on 13.01.2017.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
