package com.project.petclinic.api.service;

import com.project.petclinic.api.advice.UserNotFoundException;
import com.project.petclinic.api.dto.UserRequest;
import com.project.petclinic.api.entity.User;
import com.project.petclinic.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0,
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getEmail(),
                userRequest.getPhone());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found for id=["+id+"]");
        }
    }
}
