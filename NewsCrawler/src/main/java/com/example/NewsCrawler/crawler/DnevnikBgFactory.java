package com.example.NewsCrawler.crawler;


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
