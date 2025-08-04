package com.example.SpringWebMVC.model;

import com.example.SpringWebMVC.enums.States;

public class Post {
    private long id;
    private String content;
    private States state;

    public Post() {
    }

    public Post(long id, String content, States state) {
        this.id = id;
        this.content = content;
        this.state = state;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

}
