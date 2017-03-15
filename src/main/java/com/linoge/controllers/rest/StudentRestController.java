package com.linoge.controllers.rest;

import com.linoge.models.dto.StudentDTO;
import com.linoge.servicies.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Timo on 13.03.2017.
 */
@RestController
@RequestMapping("/")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "/requestorder", method = RequestMethod.POST)
    public void deleteSubject(@RequestParam("organisationId") Long id) {
        studentService.requestOrder(id);
    }

    @RequestMapping(path = "/createstudent", method = RequestMethod.POST)
    public Long createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudentFromDTO(studentDTO);
    }

    @RequestMapping(path = "/setgroup", method = RequestMethod.POST)
    public void setGroup(@RequestParam(value = "studentId") Long studentId,
                         @RequestParam(value = "groupId") Long groupId) {
        studentService.setGroup(studentId, groupId);
    }

    @RequestMapping(path = "/setorder", method = RequestMethod.POST)
    public void setOrder(@RequestParam(value = "studentId") Long studentId,
                         @RequestParam(value = "orderId") Long orderId) {
        studentService.setOrder(studentId, orderId);
    }

    @RequestMapping(path = "/setuser", method = RequestMethod.POST)
    public void setUser(@RequestParam(value = "studentId") Long studentId,
                        @RequestParam(value = "userId") Long userId) {
        studentService.setUser(studentId, userId);
    }
}
