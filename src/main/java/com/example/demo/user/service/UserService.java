package com.example.demo.user.service;

import com.example.demo.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private MongoTemplate mongoTemplate;
    private final String userCollectionName = "users";

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public User create(User newUser) {
        mongoTemplate.save(newUser, userCollectionName);
        return findUserById(newUser.getId());
    }

    private User findUserById(String id) {
        return mongoTemplate.findById(id, User.class, userCollectionName);
    }

}
