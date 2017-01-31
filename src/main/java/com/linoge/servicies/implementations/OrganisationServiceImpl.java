package com.linoge.servicies.implementations;

import com.linoge.dao.OrganisationDAO;
import com.linoge.models.entities.Organisation;
import com.linoge.servicies.OrganisationService;
import com.linoge.servicies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Timo on 31.01.2017.
 */
@Service
public class OrganisationServiceImpl implements OrganisationService{

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired
    StudentService studentService;

    @Override
    public List<Organisation> getOrganisationsByUserId(Long id) {
        return studentService.findStudentByUserId(id).getOrganisation();
    }
}
