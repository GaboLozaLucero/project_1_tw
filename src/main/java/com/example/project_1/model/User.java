package com.example.project_1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String _id;
    private String name;
    private List<Tweet> tweetList;

    public User(String name, List<Tweet> tweetList) {
        this.name = name;
        this.tweetList = tweetList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
}
