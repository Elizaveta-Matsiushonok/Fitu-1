package com.linoge.models.converters;

import com.linoge.models.dto.OrganisationDTO;
import com.linoge.models.entities.Organisation;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 30.01.2017.
 */
public final class OrganisationConverter {
    private OrganisationConverter() {

    }

    public static List<OrganisationDTO> convertOrganisationConverterToDTO(List<Organisation> organisations) {
        return organisations.stream()
                .map(organisation -> OrganisationDTO.builder()
                        .name(organisation.getName())
                        .build())
                .collect(toList());
    }
}
