package com.linoge.models.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Timo on 03.03.2017.
 */

@Data
@Builder
public class AdmissionOrderDTO {
    public Long id;
    public String name;
}
