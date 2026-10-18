package com.splitsmart.backend.controller;

import com.splitsmart.backend.model.User;
import com.splitsmart.backend.service.UserService;
import java.util.Optional;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController //This class receives HTTP requests and sends responses back.
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser(){
       return userService.getAllUsers();
       
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){ // @PathVariable: Take this value from the URL and put it into my Java variable.
       return userService.getUserById(id);
    }
    @PostMapping // Handles POST requests sent to /users
    public User postUser(@RequestBody User user){ // Takes the JSON data from the request and converts it into a User object
        return userService.createUser(user);
    }

}
