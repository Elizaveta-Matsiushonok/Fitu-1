package com.linoge.controllers.rest;

import com.linoge.dao.LectorDAO;
import com.linoge.models.entities.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Timo on 04.02.2017.
 */
@RestController
@RequestMapping("/")
public class LectorRestController {

    @Autowired
    LectorDAO lectorDAO;

    @RequestMapping(path = "/getlectors", method = RequestMethod.GET)
    public List<Lector> getTags() {
        return lectorDAO.findAll();
    }

    @RequestMapping(path = "/createlector", method = RequestMethod.POST)
    public void addTag(@RequestParam("lector") Lector lector) {
        lectorDAO.saveAndFlush(lector);
    }

    @RequestMapping(path = "/deletelector", method = RequestMethod.POST)
    public void deleteTag(@RequestParam("id") Long id) {
        lectorDAO.delete(id);
    }

    @RequestMapping(path = "/rewritelector", method = RequestMethod.POST)
    public void rewriteLector(@RequestParam("lector") Lector lector) {
        Lector lectorInMemory = lectorDAO.findOne(lector.getId());
        lectorInMemory.setFullName(lector.getFullName());
        lectorInMemory.setInformation(lector.getInformation());
        lectorDAO.saveAndFlush(lectorInMemory);
    }

    //add subject
    //del subject
}
