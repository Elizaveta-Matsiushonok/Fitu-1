package com.linoge.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String basis;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String number;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String time;
}
