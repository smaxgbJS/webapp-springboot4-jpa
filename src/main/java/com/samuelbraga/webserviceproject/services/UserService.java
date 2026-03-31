package com.samuelbraga.webserviceproject.services;

import com.samuelbraga.webserviceproject.entities.User;
import com.samuelbraga.webserviceproject.repositories.UserRepository;
import com.samuelbraga.webserviceproject.services.exceptions.ResourceNotFoundException;
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
           .orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public User update(Long userId, User updatedUser) {
        User existingUser = findById(userId);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }
}
