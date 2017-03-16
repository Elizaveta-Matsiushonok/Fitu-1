package com.linoge.servicies.implementations;

import com.linoge.dao.*;
import com.linoge.models.dto.StudentDTO;
import com.linoge.models.entities.*;
import com.linoge.models.enums.EducationBasis;
import com.linoge.models.enums.EducationNumber;
import com.linoge.models.enums.EducationTime;
import com.linoge.models.enums.Role;
import com.linoge.servicies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    @Autowired
    AdmissionOrderDAO orderDAO;

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
                .groupNumber(student.getGroup().getGroupNumber())
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
        Group group = groupDAO.getByGroupNumber(studentDTO.getGroupNumber());
        Student student = Student.builder()
                .fullName(convertStringToFullName(studentDTO.getFullName()))
                .group(group)
                .basis(EducationBasis.values()[Integer.parseInt(studentDTO.getBasis())])
                .time(EducationTime.values()[Integer.parseInt(studentDTO.getTime())])
                .number(EducationNumber.values()[Integer.parseInt(studentDTO.getNumber())])
                .build();

        if (studentDTO.getStudentIdNumber() != null) {
            User user = User.builder()
                    .username(studentDTO.getStudentIdNumber())
                    .accountNonLocked(true)
                    .authorities(Arrays.asList(
                            Role.ROLE_STUDENT,
                            Role.ROLE_USER
                    ))
                    .password(new BCryptPasswordEncoder().encode(studentDTO.getStudentIdNumber()))
                    .build();
            userDAO.saveAndFlush(user);
            student.setUser(user);
        }

        studentDAO.saveAndFlush(student);

        return student.getId();
    }

    @Override
    public void setGroup(Long studentId, Long groupId) {
        Group group = groupDAO.findOne(groupId);
        Student student = studentDAO.findOne(studentId);
        student.setGroup(group);
        studentDAO.saveAndFlush(student);
    }

    @Override
    public void setOrder(Long studentId, Long orderId) {
        AdmissionOrder order = orderDAO.findOne(orderId);
        Student student = studentDAO.findOne(studentId);
        student.setAdmissionOrder(order);
        studentDAO.saveAndFlush(student);
    }

    @Override
    public void setUser(Long studentId, Long userId) {
        User user = userDAO.findOne(userId);
        Student student = studentDAO.findOne(studentId);
        student.setUser(user);
        studentDAO.saveAndFlush(student);
    }
}
