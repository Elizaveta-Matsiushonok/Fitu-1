package com.linoge.servicies.implementations;

import com.linoge.dao.ArticleDAO;
import com.linoge.models.converters.ArticleConverter;
import com.linoge.models.converters.SimpleDateConverter;
import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;
import com.linoge.servicies.ArticleService;
import com.linoge.servicies.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timo on 28.12.2016.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDAO articleDAO;

    @Autowired
    TagService tagService;

    public List<Article> getArticles() {
        return articleDAO.findAll();
    }

    @Override
    public Long createArticle(String text, String title, List<Long> tagsId) {
        return articleDAO.saveAndFlush(Article.builder()
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
        return articleDAO.findByTagsContaining(tagService.findTagById(tagId));
    }

    @Override
    public Article getArticleById(Long articleId) {
        return articleDAO.findOne(articleId);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleDAO.delete(id);
    }

    @Override
    public Long createArticleFromDTO(ArticleDTO article) {
        return articleDAO.saveAndFlush(Article.builder()
                .body(article.getBody())
                .header(article.getHeader())
                .title(article.getTitle())
                .tags(article.getTags().stream()
                        .map(tagDTO -> tagService.findTagById(tagDTO.getId()))
                        .collect(Collectors.toList()))
                .date(SimpleDateConverter.getSimpleFormatDate(new Date()))
                .build())
                .getId();
    }

    @Override
    public void updateArticle(ArticleDTO article) {
        articleDAO.saveAndFlush(Article.builder()
                .id(article.getId())
                .body(article.getBody())
                .header(article.getHeader())
                .title(article.getTitle())
                .tags(article.getTags().stream()
                        .map(tagDTO -> tagService.findTagById(tagDTO.getId()))
                        .collect(Collectors.toList()))
                .date(articleDAO.getOne(article.getId()).getDate())
                .build());
    }
}