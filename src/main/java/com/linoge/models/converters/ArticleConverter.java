package com.linoge.models.converters;

import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;

import java.util.List;

import static com.linoge.models.converters.TagConverter.convertTagsCollectionToDTO;
import static java.util.stream.Collectors.toList;

/**
 * Created by Timo on 28.12.2016.
 */
public final class ArticleConverter {

    private ArticleConverter() {
    }

    public static ArticleDTO convertArticleToDTO(Article article){
        return ArticleDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .header(article.getHeader())
                .body(article.getBody())
                .tags(convertTagsCollectionToDTO(article.getTags()))
                .build();
    }

    public static List<ArticleDTO> convertArticleCollectionToDTO(List<Article> articles) {
        return articles.stream()
                .map(element -> ArticleDTO.builder()
                        .id(element.getId())
                        .title(element.getTitle())
                        .header(element.getHeader())
                        .tags(convertTagsCollectionToDTO(element.getTags()))
                        .build())
                .collect(toList());
    }
}