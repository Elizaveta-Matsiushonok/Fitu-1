package com.linoge.models.converters;

import com.linoge.models.dto.TagDTO;
import com.linoge.models.entities.Tag;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 30.12.2016.
 */
public final class TagConverter {

    private TagConverter() {
    }

    public static List<TagDTO> convertTagsCollectionToDTO(List<Tag> tags) {
        return tags.stream()
                .map(tag -> TagDTO.builder()
                        .id(tag.getId())
                        .title(tag.getTitle())
                        .build())
                .collect(toList());
    }
}
