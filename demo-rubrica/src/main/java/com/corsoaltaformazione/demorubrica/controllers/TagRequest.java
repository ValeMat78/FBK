package com.corsoaltaformazione.demorubrica.controllers;

import com.corsoaltaformazione.demorubrica.models.Tag;

import java.util.List;

public class TagRequest {
    public TagRequest(String email, List<Tag> tags) {
        this.email = email;
        this.tags = tags;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    String email;
    List<Tag> tags;
}
