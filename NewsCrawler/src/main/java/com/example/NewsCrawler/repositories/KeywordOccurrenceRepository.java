package com.example.NewsCrawler.repositories;

import com.example.NewsCrawler.entities.KeywordOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordOccurrenceRepository extends JpaRepository<KeywordOccurrence, Long> {
}
