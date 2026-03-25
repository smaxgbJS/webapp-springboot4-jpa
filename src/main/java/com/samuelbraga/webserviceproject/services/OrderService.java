package com.samuelbraga.webserviceproject.services;

import com.samuelbraga.webserviceproject.entities.Order;
import com.samuelbraga.webserviceproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Order> findByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
