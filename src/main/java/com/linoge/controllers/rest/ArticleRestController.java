package com.linoge.controllers.rest;

import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;
import com.linoge.servicies.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.linoge.models.converters.ArticleConverter.convertArticleCollectionToDTO;

/**
 * Created by Timo on 28.12.2016.
 */
@RestController
@RequestMapping("/")
public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(path = "/getarticles", method = RequestMethod.GET)
    public List<ArticleDTO> getAllArticles(){
        return convertArticleCollectionToDTO(articleService.getArticles());
    }

    @RequestMapping(path = "/getarticlebytag", method = RequestMethod.GET)
    public List<ArticleDTO> getArticleByTag(@RequestParam("tag_id") Long tagId){
        return convertArticleCollectionToDTO(articleService.getArticleByTag(tagId));
    }

    @RequestMapping(path = "/getarticlebyid", method = RequestMethod.GET)
    public Article getArticleById(@RequestParam("article_id") Long articleId){
        return articleService.getArticleById(articleId);
    }

    @RequestMapping(path = "/addarticle", method = RequestMethod.POST)
    public Long addArticle(@RequestParam("title") String title,
                        @RequestParam("tags") List<Long> tagsId,
                        @RequestParam("text") String text){
       return articleService.createArticle(text, title, tagsId);
    }

    @RequestMapping(path = "/deletearticle", method = RequestMethod.POST)
    public void deleteArticle(@RequestParam("id") Long id){
        articleService.deleteArticleById(id);
    }

    @RequestMapping(path = "/rewritearticle", method = RequestMethod.POST)
    public Long rewriteArticle(@RequestParam("id") Long id,
                            @RequestParam("title") String title,
                            @RequestParam("tags") List<Long> tagsId,
                            @RequestParam("text") String text){
        articleService.deleteArticleById(id);
        return articleService.createArticle(text, title, tagsId);
    }
}
