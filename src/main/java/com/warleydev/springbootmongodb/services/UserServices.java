package com.warleydev.springbootmongodb.services;

import com.warleydev.springbootmongodb.domain.User;
import com.warleydev.springbootmongodb.dto.UserDTO;
import com.warleydev.springbootmongodb.repositories.UserRepository;
import com.warleydev.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
