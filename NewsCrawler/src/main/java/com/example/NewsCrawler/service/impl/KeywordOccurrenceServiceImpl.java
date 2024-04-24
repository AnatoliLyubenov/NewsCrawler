package com.example.NewsCrawler.service.impl;


import com.example.NewsCrawler.entities.Keyword;
import com.example.NewsCrawler.entities.KeywordOccurrence;
import com.example.NewsCrawler.entities.News;
import com.example.NewsCrawler.entities.User;
import com.example.NewsCrawler.repositories.KeywordOccurrenceRepository;
import com.example.NewsCrawler.repositories.KeywordRepository;
import com.example.NewsCrawler.repositories.NewsRepository;
import com.example.NewsCrawler.repositories.UserRepository;
import com.example.NewsCrawler.service.KeywordOccurrenceService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class KeywordOccurrenceServiceImpl implements KeywordOccurrenceService {

    private final KeywordRepository keywordRepository;
    private final UserRepository userRepository;

    private final NewsRepository newsRepository;
    private final KeywordOccurrenceRepository keywordOccurrenceRepository;

    public KeywordOccurrenceServiceImpl(KeywordRepository keywordRepository, UserRepository userRepository, NewsRepository newsRepository, KeywordOccurrenceRepository keywordOccurrenceRepository) {
        this.keywordRepository = keywordRepository;
        this.userRepository = userRepository;
        this.newsRepository = newsRepository;
        this.keywordOccurrenceRepository = keywordOccurrenceRepository;
    }

    @Override
    public List<KeywordOccurrence> allKeywordOccurrencesBuLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        List<KeywordOccurrence> allKeywordOccurrences = keywordOccurrenceRepository.findAll();
        List<KeywordOccurrence> loggedUserKeywordOccurrences = keywordOccurrenceRepository.findAll();

        for (KeywordOccurrence keywordOccurrence : allKeywordOccurrences) {
            if (!Objects.equals(keywordOccurrence.getKeywordId().getUserId().getId(), user.getId())) {
                loggedUserKeywordOccurrences.remove(keywordOccurrence);
            }
        }
        return loggedUserKeywordOccurrences;
    }

    @Override
    public void generateDailyKeywordStatistics() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDateStr = currentDate.format(formatter);

        List<Keyword> keywords = keywordRepository.findAllByDeletedFalse();
        List<News> newsList = newsRepository.findByCreatedDate(currentDateStr);

        for (Keyword keyword : keywords) {
            int occurrence = 0;

            for (News news : newsList) {
                keyword.setName(keyword.getName().toLowerCase());
                news.setHeading(news.getHeading().toLowerCase());

                if (news.getHeading().contains(keyword.getName())) {
                    occurrence++;
                }
            }
            if (occurrence != 0) {
                KeywordOccurrence keywordOccurrence = new KeywordOccurrence();
                keywordOccurrence.setKeywordId(keyword);
                keywordOccurrence.setDailyOccurrences(occurrence);
                keywordOccurrence.setDate(LocalDate.now().toString());

                List<KeywordOccurrence> allKeywordOccurrences = keywordOccurrenceRepository.findAll();
                if (!allKeywordOccurrences.isEmpty()) {
                    boolean isAlreadySaved = false;
                    for (KeywordOccurrence keywordOccurrenceCheck : allKeywordOccurrences) {
                        if (Objects.equals(keywordOccurrenceCheck.getKeywordId().getId(), keyword.getId())) {
                            isAlreadySaved = true;
                            break;
                        }
                    }
                    if (!isAlreadySaved) {
                        keywordOccurrenceRepository.save(keywordOccurrence);
                    }
                } else {
                    keywordOccurrenceRepository.save(keywordOccurrence);
                }
            }
        }
    }
}

