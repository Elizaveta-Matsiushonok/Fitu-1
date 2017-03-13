package com.linoge.servicies.implementations;

import com.linoge.dao.*;
import com.linoge.models.dto.StudentDTO;
import com.linoge.models.entities.Group;
import com.linoge.models.entities.Reference;
import com.linoge.models.entities.Student;
import com.linoge.models.entities.User;
import com.linoge.models.enums.EducationBasis;
import com.linoge.models.enums.EducationNumber;
import com.linoge.models.enums.EducationTime;
import com.linoge.servicies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static com.linoge.models.converters.FullNameConverter.convertStringToFullName;
import static com.linoge.models.converters.StudentConverter.convertStudentToDTO;

/**
 * Created by Timo on 31.01.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    ReferenceDAO referenceDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired
    GroupDAO groupDAO;

    @Override
    public Student findStudentByUserId(Long id) {
        return studentDAO.findByUserId(id);
    }

    @Override
    public void requestOrder(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentDAO.findByUser((User) userDAO.findByUsername(authentication.getName()));
        StudentDTO studentDTO = convertStudentToDTO(student);
        referenceDAO.saveAndFlush(Reference.builder()
                .id(student.getId())
                .admissionOrder(student.getAdmissionOrder().getName())
                .beginEducationDate(student.getAdmissionOrder().getBeginDate())
                .endEducationDate(student.getAdmissionOrder().getEndDate())
                .groupNumber(student.getGroup().getGroupId())
                .organisation(organisationDAO.getOne(id).getName())
                .speciality(student.getGroup().getSpeciality().getName())
                .studentName(studentDTO.getFullName())
                .time(studentDTO.getTime())
                .type(studentDTO.getTime())
                .number(studentDTO.getNumber())
                .build());
    }

    @Override
    public Long createStudentFromDTO(StudentDTO studentDTO) {
        Group group = groupDAO.getByGroupId(studentDTO.getNumber());
        return studentDAO.saveAndFlush(Student.builder()
                .fullName(convertStringToFullName(studentDTO.getFullName()))
                .group(group)
                .basis(EducationBasis.values()[Integer.parseInt(studentDTO.getBasis())])
                .time(EducationTime.values()[Integer.parseInt(studentDTO.getTime())])
                .number(EducationNumber.values()[Integer.parseInt(studentDTO.getNumber())])
                .build())
                .getId();
    }
}
