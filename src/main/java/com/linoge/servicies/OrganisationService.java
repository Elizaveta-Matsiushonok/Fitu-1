package com.linoge.servicies;

import com.linoge.models.entities.Organisation;

import java.util.List;

/**
 * Created by Timo on 31.01.2017.
 */
public interface OrganisationService {
    List<Organisation> getOrganisationsByUserId(Long id);
}
