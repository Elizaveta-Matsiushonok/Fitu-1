package com.linoge.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Timo on 17.02.2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

    public Long id;
    public String path;
}
