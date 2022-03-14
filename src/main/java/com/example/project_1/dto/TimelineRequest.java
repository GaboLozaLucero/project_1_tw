package com.example.project_1.dto;

import com.example.project_1.model.Tweet;

public class TimelineRequest {

    private String _id;
    private String name;
    private Tweet tweet;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public String toString() {
        return "TimelineRequest{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", tweet=" + tweet +
                '}';
    }
}
