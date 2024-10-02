package com.example.cachingdemo.service;


import com.example.cachingdemo.entity.User;
import com.example.cachingdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetch user by ID with caching enabled
    @Cacheable(value="users",key="#id")
    public Optional<User> getUserById(Long id) {
        System.out.println("Fetching from database for user ID: " + id);
        return userRepository.findById(id);
    }

    // Save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
