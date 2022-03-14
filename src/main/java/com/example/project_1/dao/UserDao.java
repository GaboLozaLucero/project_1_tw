package com.example.project_1.dao;

import com.example.project_1.model.Tweet;
import com.example.project_1.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public Optional<User> findUserById(String _id);

    public List<User> getAllUsers();

    public User saveUser(User user);

    public User addTweet(String _id, Tweet tweet);
}
