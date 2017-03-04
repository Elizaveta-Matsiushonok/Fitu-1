package com.linoge.controllers.rest;

import com.linoge.dao.SubjectDAO;
import com.linoge.models.dto.SubjectDTO;
import com.linoge.servicies.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    SubjectService subjectService;

    @Autowired
    SubjectDAO subjectDAO;

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

    @RequestMapping(path = "/createsubject", method = RequestMethod.POST)
    public Long createSubject(@RequestBody SubjectDTO subject){
        return subjectService.createSubjectFromDTO(subject);
    }

    @RequestMapping(path = "/deletesubject", method = RequestMethod.POST)
    public void deleteSubject(@RequestParam("id") Long id){
        subjectDAO.delete(id);
    }

    @RequestMapping(path = "/updatesubject", method = RequestMethod.POST)
    public Long updateSubject(@RequestBody SubjectDTO subject){
        return subjectService.updateSubjectFromDTO(subject);
    }

}


