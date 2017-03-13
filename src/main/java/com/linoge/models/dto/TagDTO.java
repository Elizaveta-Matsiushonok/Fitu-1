package com.linoge.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Timo on 30.12.2016.
 */
@Data
@Builder
public class TagDTO {
    public Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String title;
}
