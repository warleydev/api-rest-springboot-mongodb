package com.warleydev.springbootmongodb.config;

import com.warleydev.springbootmongodb.domain.User;
import com.warleydev.springbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User user1 = new User(null, "Victoria Carvalho", "vicCarv@gmail.com");
        User user2 = new User(null, "Warley Melo", "warleycm7@gmail.com");
        User user3 = new User(null, "Sunda", "sunda@gmail.com");

        repository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
