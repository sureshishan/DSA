package com.airtribe.news.service;

import com.airtribe.news.entity.User;
import com.airtribe.news.entity.VerificationToken;
import com.airtribe.news.model.UserPojo;
import com.airtribe.news.repository.UserRepository;
import com.airtribe.news.repository.VerificationTokenRepository;
import com.airtribe.news.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final VerificationTokenRepository verificationTokenRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, VerificationTokenRepository verificationTokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.verificationTokenRepository = verificationTokenRepository;
    }

    public User registerUser(UserPojo userPojo) {
        User databaseUser = new User();
        databaseUser.setEmail(userPojo.getEmail());
        databaseUser.setPassword(bCryptPasswordEncoder.encode(userPojo.getPassword()));
        databaseUser.setRole("USER");
        databaseUser.setEnabled(false);
        return userRepository.save(databaseUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = userRepository.getUserByEmail(username);
        if (dbUser == null) {
            throw new UsernameNotFoundException("User not found...!");
        }
        return new org.springframework.security.core.userdetails.User(dbUser.getEmail(), dbUser.getPassword(), Collections.emptyList());
    }

    public void createVerificationToken(User registeredUser, String token) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(registeredUser);
        long expiryDate = new Date().getTime() + 1000 * 60 * 60 * 24;
        verificationToken.setExperyDate(new Date(expiryDate));
        verificationTokenRepository.save(verificationToken);
    }

    public boolean validateToken(String token) {
        VerificationToken storedToken = verificationTokenRepository.findByToken(token);
        if (storedToken == null) {
            return false;
        }
        long expiryTime = storedToken.getExperyDate().getTime();
        if (expiryTime < System.currentTimeMillis()) {
            return false;
        }

        return true;
    }

    public void enableUser(String token) {
        VerificationToken storedToken = verificationTokenRepository.findByToken(token);
        User user = storedToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        verificationTokenRepository.delete(storedToken);
    }

    public String loginUser(String email, String password) {
        User fetchedUser = userRepository.getUserByEmail(email);

        if (fetchedUser == null || !fetchedUser.isEnabled()) {
            return "User not found or not enabled.";
        }

        boolean isPasswordMatched = bCryptPasswordEncoder.matches(password, fetchedUser.getPassword());
        if (!isPasswordMatched) {
            return "Invalid Password";
        }

        String generatedToken = JwtUtil.generateToken(email).trim();
        System.out.println("[" + generatedToken + "]");
        return generatedToken;
    }

    public List<String> getUserPreferences(String email) {
        User fetchedUser = userRepository.getUserByEmail(email);
        if (fetchedUser == null || !fetchedUser.isEnabled()) {
            throw new RuntimeException("User Not found exception");
        }

        return fetchedUser.getPreferences();
    }

    public void updatePreferences(String email, List<String> preferences) {
        User fetchedUser = userRepository.getUserByEmail(email);
        if (fetchedUser == null || !fetchedUser.isEnabled()) {
            throw new RuntimeException("User Not found exception");
        }
        fetchedUser.setPreferences(preferences);
        userRepository.save(fetchedUser);
    }
}
