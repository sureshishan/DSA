package com.airtribe.news.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class PreferencesPojo {

    @NotEmpty(message = "Preferences cannot be empty")
    private List<String> preferences;

    public PreferencesPojo(List<String> preferences) {
        this.preferences = preferences;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
