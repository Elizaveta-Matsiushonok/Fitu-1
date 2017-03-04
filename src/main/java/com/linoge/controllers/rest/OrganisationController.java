package com.linoge.controllers.rest;

import com.linoge.models.converters.OrganisationConverter;
import com.linoge.models.dto.OrganisationDTO;
import com.linoge.servicies.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Timo on 31.01.2017.
 */
@RestController
@RequestMapping("/")
public class OrganisationController {

    @Autowired
    OrganisationService organisationService;

    @RequestMapping(path = "/getorganisations", method = RequestMethod.GET)
    public List<OrganisationDTO> getOrganisationsByUserId(@RequestParam(value = "id") Long id){
        return OrganisationConverter.convertOrganisationCollectionToDTO(organisationService.getOrganisationsByUserId(id));
    }
}
