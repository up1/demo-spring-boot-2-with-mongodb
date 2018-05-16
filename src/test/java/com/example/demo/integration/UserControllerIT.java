package com.example.demo.integration;


import com.example.demo.configuration.SpringProfileSwitching;
import com.example.demo.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

@ProfileValueSourceConfiguration(value = SpringProfileSwitching.class)
@IfProfileValue(name = ACTIVE_PROFILES_PROPERTY_NAME, value = "use-mongodb-embedded")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UserControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void success_register_new_user() {
        // Arrange
        User newUser = new User("test user", 35);

        //Act
        User registeredUser = restTemplate.getForObject("/user/test user/35", User.class);

        // Assert
        assertNotNull("Should have an Primary Key", registeredUser.getId());
        assertEquals(newUser.getName(), registeredUser.getName());
        assertEquals(newUser.getAge(), registeredUser.getAge());


    }


}
