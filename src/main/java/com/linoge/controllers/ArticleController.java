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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Tim on 21.01.2017.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value="name", required=false, defaultValue="World")
                                       String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping(value = "/articlecreator", method = RequestMethod.GET)
    public String articleCreator(){
        return "articlecreator";
    }

    @ModelAttribute("article")
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public Article article(@RequestParam(value = "id", required = false, defaultValue = "1")
                          Long id){
        return articleService.getArticleById(id);
    }

//    @ModelAttribute("articles")
//    @RequestMapping("/articles")
//    public List<ArticleDTO> articles(){
//        return ArticleConverter.convertArticleCollectionToDTO(articleService.getArticles());
//    }

    @ModelAttribute("articles")
    @RequestMapping("/articles")
    public List<ArticleDTO> articlesByPage(@RequestParam("number") Long number) {
        return ArticleConverter.convertArticleCollectionToDTO(articleService.getArticlesByPage(number));
    }
}
