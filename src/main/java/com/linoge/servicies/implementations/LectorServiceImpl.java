package com.linoge.servicies.implementations;

import com.linoge.dao.DepartmentDAO;
import com.linoge.dao.LectorDAO;
import com.linoge.dao.SubjectDAO;
import com.linoge.models.converters.FullNameConverter;
import com.linoge.models.dto.LectorDTO;
import com.linoge.models.entities.Lector;
import com.linoge.servicies.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by Timo on 10.02.2017.
 */
@Service
public class LectorServiceImpl implements LectorService {

    @Autowired
    LectorDAO lectorDAO;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public void createLectorFromDTO(LectorDTO lector) {
        lectorDAO.saveAndFlush(Lector.builder()
                .fullName(FullNameConverter.convertStringToFullName(lector.getFullName()))
                .department(departmentDAO.findOne(lector.getDepartment().getId()))
                .information(lector.getInformation())
                .subjects(lector.getSubjects().stream()
                        .map(subjectDTO -> subjectDAO.findOne(subjectDTO.getId()))
                        .collect(Collectors.toList()))
                .build());
    }


    @Override
    public void updateLectorFromDTO(LectorDTO lector) {
        lectorDAO.saveAndFlush(Lector.builder()
                .id(lector.getId())
                .fullName(FullNameConverter.convertStringToFullName(lector.getFullName()))
                .department(departmentDAO.findOne(lector.getDepartment().getId()))
                .information(lector.getInformation())
                .subjects(lector.getSubjects().stream()
                        .map(subjectDTO -> subjectDAO.findOne(subjectDTO.getId()))
                        .collect(Collectors.toList()))
                .build());
    }
}
