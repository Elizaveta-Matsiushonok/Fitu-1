package com.linoge.controllers;

import com.linoge.models.converters.ArticleConverter;
import com.linoge.models.dto.ArticleDTO;
import com.linoge.models.entities.Article;
import com.linoge.servicies.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Tim on 21.01.2017.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World")
                                       String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/articlecreator")
    public String articleCreator(){
        return "articlecreator";
    }

    @ModelAttribute("article")
    @RequestMapping("/article")
    public Article article(@RequestParam(value = "id", required = false, defaultValue = "1")
                          Long id){
        return articleService.getArticleById(id);
    }

    @ModelAttribute("articles")
    @RequestMapping("/articles")
    public List<ArticleDTO> articles(){
        return ArticleConverter.convertArticleCollectionToDTO(articleService.getArticles());
    }
}
