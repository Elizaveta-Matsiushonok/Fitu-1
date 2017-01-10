package com.linoge.servicies;

import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
public interface NewsService {

    List<News> getNews();

    Long createNews(String text, String title, List<Long> tagsId);

    List<News> getNewsByTag(Long tagId);

    News getNewsById(Long newsId);

    void deleteNewsById(Long id);
}
