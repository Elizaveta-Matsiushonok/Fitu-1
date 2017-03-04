package com.linoge.servicies.implementations;

import com.linoge.dao.DepartmentDAO;
import com.linoge.dao.LectorDAO;
import com.linoge.models.entities.Department;
import com.linoge.models.entities.Lector;
import com.linoge.servicies.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    @Autowired
    LectorDAO lectorDAO;

    @Override
    @Cacheable("departments")
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentDAO.findOne(id);
    }

    @Override
    @CacheEvict(value = "departments", allEntries = true)
    public void createDepartment(String description) {
        departmentDAO.saveAndFlush(Department.builder()
                .name(description)
                .build());
    }

    @Override
    public void addLectors(Long departmentId, List<Long> lectorsId) {
        Department department = departmentDAO.findOne(departmentId);
        lectorsId.forEach(id -> {
            Lector lector = lectorDAO.findOne(id);
            lector.setDepartment(department);
            lectorDAO.saveAndFlush(lector);
        });
    }

    @Override
    public void deleteLectors(Long departmentId, List<Long> lectorsId) {
        Department department = departmentDAO.findOne(departmentId);
        lectorsId.forEach(id -> {
            Lector lector = lectorDAO.findOne(id);
            lector.setDepartment(null);
            lectorDAO.saveAndFlush(lector);
        });
    }
}
