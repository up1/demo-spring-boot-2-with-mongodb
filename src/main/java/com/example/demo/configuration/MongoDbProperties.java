package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MongoDbProperties {

    private final Environment environment;

    @Autowired
    public MongoDbProperties(Environment environment) {
        this.environment = environment;
    }

    public String getDatabase() {
        return environment.getProperty("mongodb.database");
    }

    public String getHost() {
        return environment.getProperty("mongodb.host");
    }

    public int getPort() {
        return environment.getProperty("mongodb.port", Integer.class);
    }

}
