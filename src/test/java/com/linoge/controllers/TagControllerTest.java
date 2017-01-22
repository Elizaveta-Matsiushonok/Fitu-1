package com.linoge.controllers;

import com.google.common.collect.ImmutableList;
import com.linoge.models.dto.ArticleDTO;
import com.linoge.servicies.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Timo on 30.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TagControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    ArticleRestController sut;

    @Test
    public void getTags() throws Exception {
        //prepare
        when(articleService.getArticles()).thenReturn(ImmutableList.of());
        //testing
       List<ArticleDTO> news = sut.getAllArticles();
       //validate
        verify(articleService).getArticles();
    }



}