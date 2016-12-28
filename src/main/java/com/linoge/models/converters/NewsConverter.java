package com.linoge.models.converters;

import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
public class NewsConverter {

    public static List<NewsDTO> convertNewsToDTO(List<News> news){
        List<NewsDTO> newsDTO = new ArrayList<>();
        for (News tempNews : news ){
            newsDTO.add(tempNews.toDTO());
        }

        return newsDTO;
    }
}
