package com.example.demo.configuration;

import org.springframework.stereotype.Component;
import org.springframework.test.annotation.ProfileValueSource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Objects;


@Component
public class SpringProfileSwitching implements ProfileValueSource {

    @Override
    public String get(String key) {
        Assert.hasText(key, "'key' must not be empty");
        String springProfiles = System.getProperty(key);
        if (Objects.isNull(key) || StringUtils.isEmpty(springProfiles)) {
            return "use-mongodb-embedded";
        }

        return System.getProperty(key);
    }

}
