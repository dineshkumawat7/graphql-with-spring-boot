package com.example.graphql.controller;

import com.example.graphql.entity.User;
import com.example.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<User> users() {
        return userService.getUsers();
    }

    @QueryMapping
    public User userById(@Argument Long id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public User addUser(@Argument String name, @Argument String email, @Argument Integer age) {
        return userService.addUser(name, email, age);
    }
}
