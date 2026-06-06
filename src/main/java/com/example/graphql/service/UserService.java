package com.example.graphql.service;

import com.example.graphql.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService() {

        users.add(new User(
                1L,
                "Rahul Sharma",
                "rahul@example.com",
                25
        ));

        users.add(new User(
                2L,
                "Priya Singh",
                "priya@example.com",
                28
        ));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User addUser(String name, String email, Integer age) {
        User user = new User(
                (long) (users.size() + 1),
                name,
                email,
                age
        );
        users.add(user);
        return user;
    }
}
