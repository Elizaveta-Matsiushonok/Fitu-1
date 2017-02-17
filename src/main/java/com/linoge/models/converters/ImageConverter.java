package com.linoge.models.converters;

import com.linoge.models.dto.ImageDTO;
import com.linoge.models.entities.Image;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 17.02.2017.
 */
public final class ImageConverter {

    private ImageConverter() {

    }

    public static List<ImageDTO> convertImageCollectionToDTO(List<Image> images) {
        return images.stream()
                .map(image -> ImageDTO.builder()
                        .id(image.getId())
                        .path(image.getPath())
                        .build())
                .collect(toList());
    }
}
