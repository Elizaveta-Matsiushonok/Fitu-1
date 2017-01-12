package com.linoge.models.converters;

import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timo on 28.12.2016.
 */
public final class NewsConverter {

    private NewsConverter() {
    }

    public static List<NewsDTO> convertNewsCollectionToDTO(List<News> news) {
        return news.stream()
                .map(element -> NewsDTO.builder()
                        .id(element.getId())
                        .title(element.getTitle())
                        .header(element.getHeader())
                        .tags(TagConverter
                                .convertTagsCollectionToDTO(element.getTags())).build())
                .collect(Collectors.toList());
    }
}