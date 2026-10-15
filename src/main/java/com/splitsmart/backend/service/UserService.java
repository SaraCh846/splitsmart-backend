package com.splitsmart.backend.service;

import com.splitsmart.backend.model.User;
import com.splitsmart.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository; // UserService needs a UserRepository in order to access the database.

    public UserService(UserRepository userRepository) { // Automaticcaly provide the repository object
        this.userRepository = userRepository;
    }

    public User createUser(User user) { // Saving a User object in the database through UserRepository and return that User
        return userRepository.save(user);
    }

    public List<User> getAllUsers() { // gets all users from database 
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) { // gets one user by ID
        return userRepository.findById(id);
    }
}