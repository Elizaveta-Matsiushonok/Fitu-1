package com.linoge.servicies;

import com.linoge.models.entities.News;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
public interface NewsService {

    public List<News> getNews();

    public Long createNews(String text, String title, List<Long> tagsId);
}
