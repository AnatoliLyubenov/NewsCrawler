package com.example.NewsCrawler.crawler.VestiBg;

import com.example.NewsCrawler.entities.NewsFilter;
import com.example.NewsCrawler.repositories.NewsRepository;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;


public class VestiBgFactory implements CrawlController.WebCrawlerFactory<WebCrawler> {
    private final NewsFilter newsFilter;
    private final NewsRepository newsRepository;

    public VestiBgFactory(NewsFilter newsFilter, NewsRepository newsRepository) {
        this.newsFilter = newsFilter;
        this.newsRepository = newsRepository;
    }

    @Override
    public VestiBgCrawler newInstance() {
        return new VestiBgCrawler(newsFilter, newsRepository);
    }
}
