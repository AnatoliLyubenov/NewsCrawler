package com.example.NewsCrawler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/home")
    public String menu() {
        return "home";
    }
}
