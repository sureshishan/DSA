package com.airtribe.news.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    @OneToOne
    private User user;

    private Date experyDate;

    public VerificationToken() {
    }

    public VerificationToken(Long id, String token, User user, Date experyDate) {
        this.id = id;
        this.token = token;
        this.user = user;
        this.experyDate = experyDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExperyDate() {
        return experyDate;
    }

    public void setExperyDate(Date experyDate) {
        this.experyDate = experyDate;
    }
}
