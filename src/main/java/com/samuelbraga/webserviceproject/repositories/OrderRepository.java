package com.samuelbraga.webserviceproject.repositories;

import com.samuelbraga.webserviceproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<List<Order>> findByClientId(Long clientId);
}
