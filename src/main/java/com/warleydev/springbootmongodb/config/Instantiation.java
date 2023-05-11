package com.warleydev.springbootmongodb.config;

import com.warleydev.springbootmongodb.domain.Post;
import com.warleydev.springbootmongodb.domain.User;
import com.warleydev.springbootmongodb.dto.AuthorDTO;
import com.warleydev.springbootmongodb.repositories.PostRepository;
import com.warleydev.springbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Victoria Carvalho", "vicCarv@gmail.com");
        User user2 = new User(null, "Warley Melo", "warleycm7@gmail.com");
        User user3 = new User(null, "Sunda", "sunda@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "O sunda é bagunceiro", "ELE NAO PARA DE FAZER BAGUNÇA!!!", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Tenha paciência", "Aos pais presentes aqui (cof cof), tenham paciência com seus fihos", new AuthorDTO(user2));
        
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
