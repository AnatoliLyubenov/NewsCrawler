package com.example.NewsCrawler.controllers;

import com.example.NewsCrawler.entities.News;
import com.example.NewsCrawler.repositories.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping
    public String getAllNews(Model model) {
      //  List<News> news = newsRepository.findAll();
        //model.addAttribute("allNews", news);
        return "news/list";
    }
}
