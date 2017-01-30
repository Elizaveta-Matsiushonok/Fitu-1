package com.linoge.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Timo on 13.01.2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    public Long id;
    public String fullName;
    public String groupNumber;
    public List<OrganisationDTO> organisations;
}
