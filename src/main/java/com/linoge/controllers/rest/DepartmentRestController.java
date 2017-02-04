package com.linoge.controllers.rest;

import com.linoge.models.dto.DepartmentDTO;
import com.linoge.servicies.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.linoge.models.converters.DepartmentConverter.convertDepartmentCollectionToDTO;
import static com.linoge.models.converters.DepartmentConverter.convertDepartmentToDTO;

/**
 * Created by Timo on 04.02.2017.
 */
@RestController
@RequestMapping("/")
public class DepartmentRestController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(path = "/getdepartments", method = RequestMethod.GET)
    public List<DepartmentDTO> getDepartments() {
        return convertDepartmentCollectionToDTO(departmentService.getAllDepartments());
    }

    @RequestMapping(path = "/getdepartment", method = RequestMethod.GET)
    public DepartmentDTO getDepartmentById(@RequestParam("id") Long id) {
        return convertDepartmentToDTO(departmentService.getDepartmentById(id));
    }

    @RequestMapping(path = "/createdepartment", method = RequestMethod.POST)
    public void createDepartment(@RequestParam("description") String descritpion) {
        departmentService.createDepartment(descritpion);
    }

    @RequestMapping(path = "/addlectors", method = RequestMethod.POST)
    public void addLectors(@RequestParam("id") Long id,
                           @RequestParam("lectors") List<Long> lectors) {
        departmentService.addLectors(id, lectors);
    }

    @RequestMapping(path = "/removelectors", method = RequestMethod.POST)
    public void removeLectors(@RequestParam("id") Long id,
                              @RequestParam("lectors") List<Long> lectors) {
        departmentService.deleteLectors(id, lectors);
    }

}
