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

    private final static String BODY_TAG = "{<article_body>}";

    private ArticleConverter() {
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

    public static String getHeader(String text) {
        return text.substring(0, text.indexOf(BODY_TAG));
    }

    public static String getBody(String text) {
        return text.substring(text.indexOf(BODY_TAG) + BODY_TAG.length());
    }


}