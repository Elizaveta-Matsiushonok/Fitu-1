package com.linoge.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Timo on 03.02.2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    public Long id;
    public String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LectorDTO> lectors;
}
