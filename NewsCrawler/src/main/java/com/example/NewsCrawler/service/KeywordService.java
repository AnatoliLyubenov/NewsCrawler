package com.example.NewsCrawler.service;

import com.example.NewsCrawler.entities.Keyword;

import java.util.List;

public interface KeywordService {
    List<Keyword> getAllKeywordsForUser();

    Keyword getKeywordById(Long id);

    Keyword createKeyword(Keyword Keyword);

    Keyword updateKeyword(Long id, Keyword Keyword);

    void deleteKeyword(Long id);
}
