package com.warleydev.springbootmongodb.resources;

import com.warleydev.springbootmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user1 = new User("1", "Victoria", "vicCarvalho@gmail.com");
        User user2 = new User("2", "Warley", "warleycm7@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(list);
    }
}
