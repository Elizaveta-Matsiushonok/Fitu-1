package com.linoge.controllers.rest;

import com.linoge.models.dto.SubjectDTO;
import com.linoge.servicies.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.linoge.models.converters.SubjectConverter.convertSubjectCollectionToDTO;
import static com.linoge.models.converters.SubjectConverter.convertSubjectToDTO;

/**
 * Created by Timo on 04.02.2017.
 */
@RestController
@RequestMapping("/")
public class SubjectsRestController {
    @Autowired
    private SubjectService subjectService;


    @RequestMapping(path = "/getsubjects", method = RequestMethod.GET)
    public List<SubjectDTO> getAllSubjects() {
        return convertSubjectCollectionToDTO(subjectService.getAll());
    }

    /**
     * Use when need to select subjects for concrete department or speciality.
     */
    @RequestMapping(path = "/getsubjectsbyid", method = RequestMethod.GET)
    public List<SubjectDTO> getSubjects(@RequestParam("id") List<Long> subjectsId) {
        return convertSubjectCollectionToDTO(subjectService.getSubjects(subjectsId));
    }

    @RequestMapping(path = "/getsubject", method = RequestMethod.GET)
    public SubjectDTO getSubject(@RequestParam("id") Long id) {
        return convertSubjectToDTO(subjectService.getSubject(id));
    }


    //create subject
    //delete subject
}


