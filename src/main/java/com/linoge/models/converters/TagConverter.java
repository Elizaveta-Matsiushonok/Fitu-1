package com.linoge.models.converters;

import com.linoge.models.dto.TagDTO;
import com.linoge.models.entities.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Timo on 30.12.2016.
 */
public class TagConverter {

    public static List<TagDTO> convertTagsCollectionToDTO(List<Tag> tags){
        List<TagDTO> tagsDTO = new ArrayList<>(tags.size());
        tags.forEach(tag -> TagDTO.builder()
                .id(tag.getId())
                .title(tag.getTitle())
                .build());
        return tagsDTO;
    }
}
