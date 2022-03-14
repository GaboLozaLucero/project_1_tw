package com.example.project_1.api;

import com.example.project_1.dao.UserDao;
import com.example.project_1.model.Tweet;
import com.example.project_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserDao userDao;

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public TimelineRequest findTimelineById(HttpServ)

    @GetMapping("/{_id}")
    public Optional<User> UserInfo(@PathVariable("_id") String _id){
        return userDao.findUserById(_id);
    }

    @GetMapping("/list")
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @RequestMapping
    public String response(){
        return "spring boot running";
    }

    @PutMapping("/update/{user_id}")
    public User addTweet(@RequestBody Tweet tweet, @PathVariable("user_id") String _id){
        return userDao.addTweet(_id, tweet);
    }
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userDao.saveUser(user);
    }

//    private UserBl userBl;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);
//
//    @Autowired
//    public UserApi(UserBl userBl){
//        this.userBl = userBl;
//    }



}
