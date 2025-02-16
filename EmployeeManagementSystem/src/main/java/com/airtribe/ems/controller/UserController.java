package com.airtribe.ems.controller;

import com.airtribe.ems.User;
import com.airtribe.ems.model.UserPojo;
import com.airtribe.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserPojo userPojo) {
        return userService.register(userPojo);
    }
}
