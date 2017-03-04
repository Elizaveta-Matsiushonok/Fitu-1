package com.linoge.dao;

import com.linoge.models.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Timo on 03.02.2017.
 */
@Repository
public interface DepartmentDAO extends JpaRepository<Department, Long> {
}
