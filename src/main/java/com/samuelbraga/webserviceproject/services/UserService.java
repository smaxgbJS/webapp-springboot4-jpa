package com.samuelbraga.webserviceproject.services;

import com.samuelbraga.webserviceproject.entities.User;
import com.samuelbraga.webserviceproject.repositories.UserRepository;
import com.samuelbraga.webserviceproject.services.exceptions.DatabaseException;
import com.samuelbraga.webserviceproject.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void delete(Long userId) throws DatabaseException {
        try {
            if (!userRepository.existsById(userId)) {
                throw new ResourceNotFoundException(userId);
            }
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(userId);
        } catch (DataAccessException e) {
            throw new DatabaseException("Could not delete a user with orders in database.");
        }
    }

    public User update(Long userId, User updatedUser) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException(userId);
        }

        User existingUser = findById(userId);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }
}
