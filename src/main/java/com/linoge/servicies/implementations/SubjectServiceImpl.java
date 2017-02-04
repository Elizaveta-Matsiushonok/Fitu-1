package com.linoge.servicies.implementations;

import com.linoge.dao.SubjectDAO;
import com.linoge.models.entities.Subject;
import com.linoge.servicies.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 04.02.2017.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public List<Subject> getSubjects(List<Long> subjectsId) {
        return subjectsId.stream()
                .map(id -> subjectDAO.findOne(id))
                .collect(toList());
    }

    @Override
    public List<Subject> getAll() {
        return subjectDAO.findAll();
    }

    @Override
    public Subject getSubject(Long id) {
        return subjectDAO.findOne(id);
    }


}
