package com.airtribe.news.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome...!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello from JWT";
    }
}
