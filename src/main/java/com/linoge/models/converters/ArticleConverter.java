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

    public static ArticleDTO convertArticleToDTO(Article article){
        return ArticleDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .header(article.getHeader())
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

    public static void main(String[] args) {

        Article article = Article.builder().header("header").id(42L).title("Hello wordl").build();
        ArticleDTO tmp = new Builder(article).header().id().build();
        System.out.println(tmp);
    }

//    buildCollection(articles).title().body().tags();
//    buildSingle(article).title().body().tags();

    public static String getHeader(String text) {
        return text.substring(0, text.indexOf(BODY_TAG));
    }

    public static String getBody(String text) {
        return text.substring(text.indexOf(BODY_TAG) + BODY_TAG.length());
    }

    void buildSingle(Article article) {
        ArticleDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .header(article.getHeader())
                .tags(convertTagsCollectionToDTO(article.getTags()));
    }

    public static class Builder {
        private final Article article;
        private final ArticleDTO.ArticleDTOBuilder buidler = ArticleDTO.builder();
//        private final ArticleDTO dto = ArticleDTO.builder();

        public Builder(Article article) {
            this.article = article;
        }

        public Builder title() {
            buidler.title(article.getTitle());
            return this;
        }

        public Builder header() {
            buidler.header(article.getHeader());
            return this;
        }

        public Builder id() {
            buidler.id(article.getId());
            return this;
        }

        public Builder body() {
            buidler.title(article.getTitle());
            return this;
        }

        public ArticleDTO build() {
            return buidler.build();
        }
    }


}