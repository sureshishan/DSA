package com.airtribe.news.controller;

import com.airtribe.news.service.NewsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newService;

    public NewsController(NewsService newService) {
        this.newService = newService;
    }

    @GetMapping
    public Map<String, Object> getNews(@AuthenticationPrincipal UserDetails userDetails) {
        return newService.fetchNewsForUser(userDetails.getUsername());
    }
}
