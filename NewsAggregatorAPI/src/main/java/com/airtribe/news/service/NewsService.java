package com.airtribe.news.service;

import com.airtribe.news.entity.User;
import com.airtribe.news.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class NewsService {

/*    private static final String NEWS_API_KEY = "your_newsapi_key";
    private static final String NEWS_API_URL = "https://newsapi.org/v2/top-headlines";*/

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    public NewsService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> fetchNewsForUser(String email) {
        User fetchedUser = userRepository.getUserByEmail(email);
        if (fetchedUser == null || !fetchedUser.isEnabled()) {
            throw new RuntimeException("User not found or not enabled.");
        }

        List<String> preferences = fetchedUser.getPreferences();

        String category = String.join(",", preferences);

       /* String url = UriComponentsBuilder.fromHttpUrl(NEWS_API_URL)
                .queryParam("apiKey", NEWS_API_KEY)
                .queryParam("category", category)
                .queryParam("language", "en")
                .toUriString();

        return restTemplate.getForObject(url, Map.class);*/

        return null;
    }
}
