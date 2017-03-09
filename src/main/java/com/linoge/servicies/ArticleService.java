package com.linoge.servicies;

import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;

import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
public interface ArticleService {

    List<Article> getArticles();

    List<Article> getArticleByTag(Long tagId);

    Article getArticleById(Long articleId);

    void deleteArticleById(Long id);

    Long createArticleFromDTO(ArticleDTO article);

    void updateArticle(ArticleDTO article);

    List<Article> getArticlesByPage(Integer number);
}
