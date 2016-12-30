package com.linoge.servicies;

import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;
import com.linoge.models.entities.Tag;
import com.linoge.repositories.NewsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Timo on 28.12.2016.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    TagService tagService;

    private final String BODY_TAG = "{<news_body>}";

    public List<News> getNews(){
        return newsRepository.findAll();
    }

    @Override
    public Long createNews(String text, String title, List<Long> tagsId){
        String header = text.substring(0, text.indexOf(BODY_TAG));
        String body = text.substring(text.indexOf(BODY_TAG) + BODY_TAG.length());
        List<Tag> tags = new ArrayList<>();
        for( Long id : tagsId){
            tags.add(tagService.findTagById(id));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        News news = News.builder()
                .header(header)
                .body(body)
                .title(title)
                .tags(tags)
                .date(sdf.format(new Date())).build();
        return newsRepository.saveAndFlush(news).getId();
    }

    @Override
    public List<News> getNewsByTag(Long tagId) {
        return newsRepository.findByTagsContaining(tagService.findTagById(tagId));
    }

    @Override
    public News getNewsById(Long newsId) {
        return newsRepository.findOne(newsId);
    }


}