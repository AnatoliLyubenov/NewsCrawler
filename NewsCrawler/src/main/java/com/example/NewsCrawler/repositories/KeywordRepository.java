package com.example.NewsCrawler.repositories;

import com.example.NewsCrawler.entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    List<Keyword> findAll();
}
