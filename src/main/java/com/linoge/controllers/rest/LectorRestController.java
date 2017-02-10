package com.linoge.controllers.rest;

import com.linoge.dao.LectorDAO;
import com.linoge.models.dto.LectorDTO;
import com.linoge.servicies.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.linoge.models.converters.LectorConverter.convertLectorCollectionToDTO;

/**
 * Created by Timo on 04.02.2017.
 */
@RestController
@RequestMapping("/")
public class LectorRestController {

    @Autowired
    LectorDAO lectorDAO;

    @Autowired
    LectorService lectorService;

    @RequestMapping(path = "/getlectors", method = RequestMethod.GET)
    public List<LectorDTO> getLectors() {
        return convertLectorCollectionToDTO(lectorDAO.findAll());
    }

    @RequestMapping(path = "/createlector", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createLector(@RequestBody LectorDTO lector) {
        lectorService.createLectorFromDTO(lector);
    }

    @RequestMapping(path = "/deletelector", method = RequestMethod.POST)
    public void deleteLector(@RequestParam("id") Long id) {
        lectorDAO.delete(id);
    }

    @RequestMapping(path = "/rewritelector", method = RequestMethod.POST)
    public void rewriteLector(@RequestBody LectorDTO lector) {
        lectorService.updateLectorFromDTO(lector);
    }
}
