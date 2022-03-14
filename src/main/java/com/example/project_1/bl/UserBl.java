package com.example.project_1.bl;

import com.example.project_1.dao.UserDao;
import com.example.project_1.model.Tweet;
import com.example.project_1.model.User;
import com.example.project_1.repository.TweetRepository;
import com.example.project_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"User"})
public class UserBl implements UserDao {

    @Autowired
    private UserRepository userRepository;
    private TweetRepository tweetRepository;

    @Override
    @Cacheable(key="#_id")
    public Optional<User> findUserById(String _id) {
        return userRepository.findById(_id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addTweet(String _id, Tweet tweet) {
        Optional<User> findById = userRepository.findById(_id);
        if(findById.isPresent()){
            User userFound = findById.get();
            System.out.println(userFound.getName());
            List<Tweet> newTweetList = userFound.getTweetList();
            newTweetList.add(tweet);
            userFound.setTweetList(newTweetList);
            return userRepository.save(userFound);
        }
        return null;
    }

}
