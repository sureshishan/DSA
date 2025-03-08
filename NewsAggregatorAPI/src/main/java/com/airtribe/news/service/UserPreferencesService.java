package com.airtribe.news.service;

import com.airtribe.news.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPreferencesService {

    private final UserRepository userRepository;

    public UserPreferencesService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
