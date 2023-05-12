package com.warleydev.springbootmongodb.config;

import com.warleydev.springbootmongodb.domain.Post;
import com.warleydev.springbootmongodb.domain.User;
import com.warleydev.springbootmongodb.dto.AuthorDTO;
import com.warleydev.springbootmongodb.dto.CommentDTO;
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
        Post post3 = new Post(null, sdf.parse("22/03/2018"), "a mamãe é louca", "ehauea osdidas blue blu blea shinguinong nai", new AuthorDTO(user3));

        CommentDTO c1 = new CommentDTO("ablubloeablable juhague", sdf.parse("21/03/2018"), new AuthorDTO(user3));
        CommentDTO c2 = new CommentDTO("Paciência? Quando vou ter paciência com duas crianças em casa me deixando maluca?", sdf.parse("22/03/2018"), new AuthorDTO(user1));
        CommentDTO c3 = new CommentDTO("Sua mãe realmente ta ficando bilu teteia!", sdf.parse("22/03/2018"), new AuthorDTO(user2));

        post1.getComments().add(c1);
        post2.getComments().add(c2);
        post3.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        user1.getPosts().add(post1);
        user2.getPosts().add(post2);
        user3.getPosts().add(post3);
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
