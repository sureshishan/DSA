package com.airtribe.news.controller;

import com.airtribe.news.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {
    private final UserService userService;

    public PreferenceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<String> getUserPreferences(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.getUserPreferences(userDetails.getUsername());
    }

    @PutMapping
    public void updateUserPreferences(@AuthenticationPrincipal UserDetails userDetails, @Valid @RequestBody List<String> preferences) {
        userService.updatePreferences(userDetails.getUsername(), preferences);
    }
}
