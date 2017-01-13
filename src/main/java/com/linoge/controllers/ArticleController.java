package com.linoge.controllers;

import com.linoge.models.converters.ArticleConverter;
import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;
import com.linoge.servicies.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Timo on 28.12.2016.
 */
@RestController
@RequestMapping("/")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(path = "/getarticles", method = RequestMethod.GET)
    public List<ArticleDTO> getAllArticles(){
        return ArticleConverter.convertArticleCollectionToDTO(articleService.getArticles());
    }

    @RequestMapping(path = "/getarticlebytag", method = RequestMethod.GET)
    public List<ArticleDTO> getArticleByTag(@RequestParam("tag_id") Long tagId){
        return ArticleConverter.convertArticleCollectionToDTO(articleService.getArticleByTag(tagId));
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

    @RequestMapping(path = "/addimage", method = RequestMethod.POST)
    public String addImage(@RequestParam("name") String name,
                           @RequestParam ("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return name + "-uploaded";
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }


}
