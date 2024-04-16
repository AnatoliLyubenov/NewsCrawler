package com.example.NewsCrawler.repositories;

import com.example.NewsCrawler.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
