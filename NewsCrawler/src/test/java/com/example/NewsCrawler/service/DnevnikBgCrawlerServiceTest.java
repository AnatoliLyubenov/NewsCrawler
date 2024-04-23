package com.example.NewsCrawler.service;

import com.example.NewsCrawler.crawler.DnekvikBg.DnevnikBgCrawlerService;
import com.example.NewsCrawler.repositories.NewsFilterRepository;
import com.example.NewsCrawler.repositories.NewsRepository;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class DnevnikBgCrawlerServiceTest {

    @Mock
    private NewsFilterRepository newsFilterRepository;

    @Mock
    private NewsRepository newsRepository;

    @Mock
    private CrawlController crawlController;

    @InjectMocks
    private DnevnikBgCrawlerService dnevnikBgCrawlerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crawl_DoesNotProcessCrawl_WhenNoNewsFiltersFound() throws Exception {
        when(newsFilterRepository.findAllByNewsSite("dnevnik.bg")).thenReturn(List.of());

        dnevnikBgCrawlerService.crawl();

        verify(crawlController, never()).start((Class<WebCrawler>) any(), anyInt());
    }
}

