package com.example.NewsCrawler.repositories;


import com.example.NewsCrawler.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
