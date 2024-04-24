package com.example.NewsCrawler.service;


import com.example.NewsCrawler.entities.KeywordOccurrence;

import java.util.List;

public interface KeywordOccurrenceService {
    void generateDailyKeywordStatistics();
    List<KeywordOccurrence> allKeywordOccurrencesBuLoggedUser();
}
