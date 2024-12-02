package com.renu.todo.configuration;

import com.renu.todo.dal.InMemoryTodorepo;
import com.renu.todo.dal.MongoTodorepo;
import com.renu.todo.dal.Todorepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Todoconfig {

    @Bean(name = "todoRepo")
    @Profile("mongodb")
    public Todorepo mongoTodorepo(MongoTodorepo mongoTodorepo){
        System.out.println("Using Mongodb repository");
        return mongoTodorepo;
    }

    @Bean(name = "todoRepo")
    @Profile("memory")
    public Todorepo inmemoryTodorepo(InMemoryTodorepo inMemoryTodorepo){
        System.out.println("Using InMemory repository");
        return inMemoryTodorepo;
    }
    
}
