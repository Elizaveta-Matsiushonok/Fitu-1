package com.linoge.controllers;

import com.google.common.collect.ImmutableList;
import com.linoge.models.dto.NewsDTO;
import com.linoge.servicies.NewsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Timo on 30.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TagControllerTest {

    @Mock
    private NewsService newsService;

    @InjectMocks
    NewsController sut;

    @Test
    public void getTags() throws Exception {
        //prepare
        when(newsService.getNews()).thenReturn(ImmutableList.of());
        //testing
       List<NewsDTO> news = sut.getAllNews();
       //validate
        verify(newsService).getNews();
    }



}