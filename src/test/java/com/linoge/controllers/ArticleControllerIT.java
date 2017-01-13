package com.linoge.controllers;

import com.google.common.collect.ImmutableList;
import com.linoge.models.dto.ArticleDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Created by Timo on 30.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ArticleControllerIT {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getAllNews() throws Exception {
        ResponseEntity<List<ArticleDTO>> responseEntity = restTemplate
                .exchange("http://localhost:8081/getnews", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<ArticleDTO>>() {
                        });
        List<ArticleDTO> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(3));
        List<Long> actualId = actualList.stream()
                .map(NewsDTO ->
                        NewsDTO.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualId, containsInAnyOrder(1L, 2L, 3L));
    }
}