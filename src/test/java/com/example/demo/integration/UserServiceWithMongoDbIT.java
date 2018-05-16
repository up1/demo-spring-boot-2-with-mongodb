package com.example.demo.integration;

import com.example.demo.configuration.SpringProfileSwitching;
import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

@ProfileValueSourceConfiguration(value = SpringProfileSwitching.class)
@IfProfileValue(name = ACTIVE_PROFILES_PROPERTY_NAME, value = "use-mongodb-embedded")
@RunWith(SpringRunner.class)
@DataMongoTest(includeFilters = @ComponentScan.Filter(Service.class))
public class UserServiceWithMongoDbIT {

    @Autowired
    private UserService userService;

    @Test
    public void success_with_create_new_user() {
        // Arrange
        User newUser = new User("test user", 35);

        // Act
        User createdUser = userService.create(newUser);

        // Assert
        assertNotNull(createdUser.getId());
        assertEquals(newUser.getName(), createdUser.getName());
        assertEquals(newUser.getAge(), createdUser.getAge());
    }


}
