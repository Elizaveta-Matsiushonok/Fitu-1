package com.linoge.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Timo on 03.02.2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    public Long id;
    public String description;
}
