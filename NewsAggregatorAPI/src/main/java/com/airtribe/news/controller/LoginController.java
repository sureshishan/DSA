package com.airtribe.news.controller;

import com.airtribe.news.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signIn")
    public String signIn(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }

}
