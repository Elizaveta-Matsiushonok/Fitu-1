package com.linoge.servicies;

import com.linoge.models.converters.ArticleConverter;
import com.linoge.models.converters.SimpleDateConverter;
import com.linoge.models.entities.Article;
import com.linoge.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Timo on 28.12.2016.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    TagService tagService;

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    @Override
    public Long createArticle(String text, String title, List<Long> tagsId){
        return articleRepository.saveAndFlush(Article.builder()
                .header(ArticleConverter.getHeader(text))
                .body(ArticleConverter.getBody(text))
                .title(title)
                .tags(tagsId.stream()
                        .map(tag -> tagService.findTagById(tag))
                        .collect(Collectors.toList()))
                .date(SimpleDateConverter.getSimpleFormatDate(new Date())).build())
                .getId();
    }

    @Override
    public List<Article> getArticleByTag(Long tagId) {
        return articleRepository.findByTagsContaining(tagService.findTagById(tagId));
    }

    @Override
    public Article getArticleById(Long articleId) {
        return articleRepository.findOne(articleId);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.delete(id);
    }


}