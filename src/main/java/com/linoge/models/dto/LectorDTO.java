package com.linoge.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
@Data
@Builder
public class LectorDTO {

    public Long id;
    public String fullName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DepartmentDTO department;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubjectDTO> subjects;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String information;
}
