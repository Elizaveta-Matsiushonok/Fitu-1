package com.linoge.servicies.implementations;

import com.linoge.dao.ArticleDAO;
import com.linoge.dao.ImageDAO;
import com.linoge.models.converters.SimpleDateConverter;
import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;
import com.linoge.models.shared.FileWorker;
import com.linoge.servicies.ArticleService;
import com.linoge.servicies.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 28.12.2016.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private static final int ARTICLE_COUNT_ON_PAGE = 10;
    private static final String SORTING_FIELD = "date";

    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    ImageDAO imageDAO;
    @Autowired
    TagService tagService;


    @Override
    @Cacheable("articles")
    public List<Article> getArticles() {
        return articleDAO.findAll();
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
    @Caching(evict = {
            @CacheEvict(value = "articles", allEntries = true),
            @CacheEvict(value = "articles_pages", allEntries = true)
    })
    public void deleteArticleById(Long id) {
        Article article = articleDAO.findOne(id);
        article.getImages().forEach(image -> {
            try {
                FileWorker.delete(image.getId());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        articleDAO.delete(id);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "articles", allEntries = true),
            @CacheEvict(value = "articles_pages", allEntries = true)
    })
    public Long createArticleFromDTO(ArticleDTO article) {
        Long result = articleDAO.saveAndFlush(Article.builder()
                .body(article.getBody())
                .header(article.getHeader())
                .title(article.getTitle())
                .tags(article.getTags().stream()
                        .map(tagDTO -> tagService.findTagById(tagDTO.getId()))
                        .collect(toList()))
                .date(SimpleDateConverter.getSimpleFormatDate(new Date()))
                .build())
                .getId();
        addImages(article.getImageId(), result);
        return result;

    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "articles", allEntries = true),
            @CacheEvict(value = "articles_pages", allEntries = true)
    })
    public void updateArticle(ArticleDTO article) {
        Long result = articleDAO.saveAndFlush(Article.builder()
                .id(article.getId())
                .body(article.getBody())
                .header(article.getHeader())
                .title(article.getTitle())
                .tags(article.getTags().stream()
                        .map(tagDTO -> tagService.findTagById(tagDTO.getId()))
                        .collect(toList()))
                .date(articleDAO.getOne(article.getId()).getDate())
                .build())
                .getId();
        addImages(article.getImageId(), result);
    }

    private void addImages(List<Long> images, Long articleId) {
        Article article = articleDAO.getOne(articleId);
        imageDAO.findAll(images).forEach(image -> {
            image.setArticle(article);
            imageDAO.saveAndFlush(image);
        });
    }

    @Override
    @Cacheable(value = "articles_pages", key = "#number")
    public List<Article> getArticlesByPage(Integer number) {
        int count = (((int) articleDAO.count() - 1) / ARTICLE_COUNT_ON_PAGE);
        return articleDAO.findAll(new PageRequest(count - number, ARTICLE_COUNT_ON_PAGE,
                Sort.Direction.DESC, SORTING_FIELD)).getContent();
    }

    @Override
    public Long getArticlesCount() {
        Long articles = articleDAO.count();
        Long count = articles / ARTICLE_COUNT_ON_PAGE;
        if (articles % 10 > 0) {
            count++;
        }
        return count;
    }
}