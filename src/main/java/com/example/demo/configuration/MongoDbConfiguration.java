package com.example.demo.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@Profile("!use-mongodb-embedded")
public class MongoDbConfiguration {

    private final MongoDbProperties mongoDbProperties;

    public MongoDbConfiguration(MongoDbProperties mongoDbProperties) {
        this.mongoDbProperties = mongoDbProperties;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient(mongoDbProperties.getHost(), mongoDbProperties.getPort());
        return new SimpleMongoDbFactory(mongoClient, mongoDbProperties.getDatabase());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

}
