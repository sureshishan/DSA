package com.airtribe.news.controller;

import com.airtribe.news.entity.User;
import com.airtribe.news.model.UserPojo;
import com.airtribe.news.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserPojo userPojo) {
        User registeredUser = userService.registerUser(userPojo);
        String token = UUID.randomUUID().toString();
        String applicationUrl = "http://localhost:9002/verifyRegistration?token=" + token;
        userService.createVerificationToken(registeredUser, token);
        System.out.println("Verification token created for user:" + registeredUser.getEmail());
        System.out.println("Verification url please click to verify your email " + applicationUrl);
        return registeredUser;
    }

    @PostMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam String token) {
        boolean isValid = userService.validateToken(token);
        if (isValid) {
            userService.enableUser(token);
            return "User enabled successfully.";
        }
        return "Invalid user.";

    }
}
