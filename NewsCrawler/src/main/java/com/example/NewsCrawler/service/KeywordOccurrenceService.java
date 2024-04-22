package com.example.NewsCrawler.service;

import com.web.crawler.WebCrawler.entities.KeywordOccurrence;

import java.util.List;

public interface KeywordOccurrenceService {
    void generateDailyKeywordStatistics();
    List<KeywordOccurrence> allKeywordOccurrencesBuLoggedUser();
}
