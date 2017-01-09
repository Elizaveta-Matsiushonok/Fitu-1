package com.linoge.models.converters;

import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
public class NewsConverter {

    public static List<NewsDTO> convertNewsCollectionToDTO(List<News> news){
        List<NewsDTO> newsDTO = new ArrayList<>();
        news.forEach(element -> newsDTO.add(NewsDTO.builder()
                .id(element.getId())
                .title(element.getTitle())
                .header(element.getHeader())
                .tags(TagConverter
                        .convertTagsCollectionToDTO(element.getTags()))
                .build())
        );
        return newsDTO;
    }
}