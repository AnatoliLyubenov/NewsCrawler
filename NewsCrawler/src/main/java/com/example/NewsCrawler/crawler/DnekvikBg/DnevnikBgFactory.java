package com.example.NewsCrawler.crawler.DnekvikBg;

import com.example.NewsCrawler.entities.NewsFilter;
import com.example.NewsCrawler.repositories.NewsRepository;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;


public class DnevnikBgFactory implements CrawlController.WebCrawlerFactory<WebCrawler> {
    private final NewsFilter newsFilter;
    private final NewsRepository newsRepository;

    public DnevnikBgFactory(NewsFilter newsFilter, NewsRepository newsRepository) {
        this.newsFilter = newsFilter;
        this.newsRepository = newsRepository;
    }

    @Override
    public DnevnikBgCrawler newInstance() {
        return new DnevnikBgCrawler(newsFilter, newsRepository);
    }
}
