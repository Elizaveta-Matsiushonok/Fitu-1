package com.linoge.servicies.implementations;

import com.linoge.dao.DepartmentDAO;
import com.linoge.models.entities.Department;
import com.linoge.servicies.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return null;
    }

    @Override
    public void createDepartment(String description) {

    }
}
