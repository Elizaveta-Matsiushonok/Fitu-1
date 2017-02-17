package com.linoge.controllers.rest;

import com.linoge.models.dto.ArticleDTO;
import com.linoge.servicies.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public List<ArticleDTO> getAllArticles() {
        return convertArticleCollectionToDTO(articleService.getArticles());
    }

    @RequestMapping(path = "/getarticlebytag", method = RequestMethod.GET)
    public List<ArticleDTO> getArticleByTag(@RequestParam("id") Long tagId) {
        return convertArticleCollectionToDTO(articleService.getArticleByTag(tagId));
    }

    @RequestMapping(path = "/createarticle", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Long createArticle(@RequestBody ArticleDTO article) {
        return articleService.createArticleFromDTO(article);
    }

    @RequestMapping(path = "/deletearticle", method = RequestMethod.POST)
    public void deleteArticle(@RequestParam("id") Long id) {
        articleService.deleteArticleById(id);
    }

    @RequestMapping(path = "/changearticle", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void changeArticle(@RequestBody ArticleDTO article){
        articleService.updateArticle(article);
    }

    @RequestMapping(path = "/addimages", method = RequestMethod.POST)
    public void addImages(@RequestParam("list") List<Long> list,
                          @RequestParam("id") Long articleId) {
        articleService.addImages(list, articleId);
    }
}
