package com.linoge.servicies;

import com.linoge.models.entities.Subject;

import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
public interface SubjectService {

    List<Subject> getSubjects(List<Long> subjectsId);

    List<Subject> getAll();

    Subject getSubject(Long id);
}
