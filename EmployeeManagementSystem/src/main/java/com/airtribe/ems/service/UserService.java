package com.airtribe.ems.service;

import com.airtribe.ems.User;
import com.airtribe.ems.model.UserPojo;
import com.airtribe.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService /*implements UserDetailsService */{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User register(UserPojo userPojo) {
        User user = new User();
        user.setEmail(userPojo.getEmail());
//        user.setPassword(passwordEncoder.encode(userPojo.getPassword()));
        user.setRole("USER");
        user.setEnabled(false);
        return userRepository.save(user);
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }*/
}
