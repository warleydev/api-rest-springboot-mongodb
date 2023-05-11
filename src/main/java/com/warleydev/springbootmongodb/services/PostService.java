package com.warleydev.springbootmongodb.services;

import com.warleydev.springbootmongodb.domain.Post;
import com.warleydev.springbootmongodb.repositories.PostRepository;
import com.warleydev.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
