package com.linoge.controllers;

import com.linoge.models.converters.NewsConverter;
import com.linoge.models.dto.NewsDTO;
import com.linoge.models.entities.News;
import com.linoge.servicies.NewsService;
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
@CrossOrigin()
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping(path = "/getnews", method = RequestMethod.GET)
    public List<NewsDTO> getAllNews(){
        return NewsConverter.convertNewsCollectionToDTO(newsService.getNews());
    }

    @RequestMapping(path = "/getnewsbytag", method = RequestMethod.GET)
    public List<NewsDTO> getNewsByTag(@RequestParam("tagid") Long tagId){
        return NewsConverter.convertNewsCollectionToDTO(newsService.getNewsByTag(tagId));
    }

    @RequestMapping(path = "/getnewsbyid", method = RequestMethod.GET)
    public News getNewsById(@RequestParam("newsid") Long newsId){
        return newsService.getNewsById(newsId);
    }

//    @RequestMapping(path = "/getnews", method = RequestMethod.GET)
//    public List<News> getNews(){
//        return newsService.getNews();
//    }

    @RequestMapping(path = "/addnews", method = RequestMethod.POST)
    public Long addNews(@RequestParam("title") String title,
                        @RequestParam("tags") List<Long> tagsId,
                        @RequestParam("text") String text){

       return newsService.createNews(text, title, tagsId);
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
