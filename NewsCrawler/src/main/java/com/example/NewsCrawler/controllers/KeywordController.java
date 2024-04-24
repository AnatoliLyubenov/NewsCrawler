package com.example.NewsCrawler.controllers;

import com.example.NewsCrawler.entities.Keyword;
import com.example.NewsCrawler.entities.KeywordOccurrence;
import com.example.NewsCrawler.service.KeywordOccurrenceService;
import com.example.NewsCrawler.service.KeywordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/keywords")
public class KeywordController {

    private final KeywordService keywordService;
    private final KeywordOccurrenceService keywordOccurrenceService;

    public KeywordController(KeywordService keywordService, KeywordOccurrenceService keywordOccurrenceService) {
        this.keywordService = keywordService;
        this.keywordOccurrenceService = keywordOccurrenceService;
    }

    @GetMapping
    public String getAllKeywords(Model model) {
        List<Keyword> keywords = keywordService.getAllKeywordsForUser();
        model.addAttribute("keywords", keywords);
        return "keyword/list";
    }

    @GetMapping("/occurrences")
    public String getAllKeywordOccurrences(Model model) {
        List<KeywordOccurrence> keywordOccurrences = keywordOccurrenceService.allKeywordOccurrencesBuLoggedUser();
        model.addAttribute("keywordOccurrences", keywordOccurrences);
        return "keywordOccurrences/list";
    }

    @GetMapping("/{id}")
    public String getKeywordById(@PathVariable Long id, Model model) {
        Keyword keyword = keywordService.getKeywordById(id);
        model.addAttribute("keyword", keyword);
        return "keyword/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("keyword", new Keyword());

        List<Keyword> keywords = keywordService.getAllKeywordsForUser();
        model.addAttribute("keywords", keywords);
        return "keyword/form";
    }

    @PostMapping("/create")
    public String createKeyword(@ModelAttribute("keyword") Keyword keyword) {
        System.out.println("keyword "  + keyword.getName());
        keywordService.createKeyword(keyword);
        return "redirect:/keywords";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Keyword keyword = keywordService.getKeywordById(id);
        model.addAttribute("keyword", keyword);

        List<Keyword> keywords = keywordService.getAllKeywordsForUser();
        model.addAttribute("keywords", keywords);
        return "keyword/edit";
    }

    @PostMapping("/update/{id}")
    public String updateKeyword(@PathVariable Long id, @ModelAttribute Keyword keyword) {
        keywordService.updateKeyword(id, keyword);
        return "redirect:/keywords";
    }

    @PostMapping("/delete/{id}")
    public String deleteKeyword(@PathVariable Long id) {
        keywordService.deleteKeyword(id);
        return "redirect:/keywords";
    }
}

