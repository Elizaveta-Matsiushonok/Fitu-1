package com.linoge.models.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Timo on 17.02.2017.
 */
@Data
@Builder
public class ImageDTO {

    public Long id;
    public String path;
}
