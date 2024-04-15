package com.example.NewsCrawler.repositories;

import com.web.crawler.WebCrawler.entities.User;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
