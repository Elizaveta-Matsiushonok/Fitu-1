package com.linoge.servicies;

import com.linoge.models.entities.Department;

import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void createDepartment(String description);

    void addLectors(Long departmentId, List<Long> lectorsId);

    void deleteLectors(Long departmentId, List<Long> lectorsId);
}
