package com.samuelbraga.webserviceproject.repositories;

import com.samuelbraga.webserviceproject.entities.OrderItem;
import com.samuelbraga.webserviceproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { }
