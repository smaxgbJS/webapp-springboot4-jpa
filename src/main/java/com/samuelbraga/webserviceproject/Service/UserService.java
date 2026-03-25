package com.samuelbraga.webserviceproject.Service;

import com.samuelbraga.webserviceproject.entities.User;
import com.samuelbraga.webserviceproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
       return userRepository.findById(userId)
           .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
