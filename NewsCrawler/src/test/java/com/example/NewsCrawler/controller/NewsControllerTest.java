package com.example.NewsCrawler.controller;


import com.example.NewsCrawler.controllers.NewsController;
import com.example.NewsCrawler.entities.News;
import com.example.NewsCrawler.repositories.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewsControllerTest {

    @Mock
    private NewsRepository newsRepository;

    @Mock
    private Model model;

    @InjectMocks
    private NewsController newsController;

    @Test
    public void testGetAllNews() {
        List<News> newsList = Arrays.asList(new News(), new News());
        when(newsRepository.findAll()).thenReturn(newsList);

        String viewName = newsController.getAllNews(model);

        assertThat(viewName).isEqualTo("news/list");
        verify(model).addAttribute("allNews", newsList);
    }
}
