package com.samuelbraga.webserviceproject.config;

import com.samuelbraga.webserviceproject.entities.Order;
import com.samuelbraga.webserviceproject.entities.User;
import com.samuelbraga.webserviceproject.enums.OrderStatus;
import com.samuelbraga.webserviceproject.repositories.OrderRepository;
import com.samuelbraga.webserviceproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(List.of(u1, u2));

        Order o1 = new Order(null, Instant.now(), OrderStatus.WAINTING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.now().plus(10, ChronoUnit.MINUTES), OrderStatus.PAID, u1);
        Order o3 = new Order(null, Instant.now(), OrderStatus.SHIPPED, u2);
        Order o4 = new Order(null, Instant.now().plus(10, ChronoUnit.MINUTES), OrderStatus.SHIPPED, u2);

        orderRepository.saveAll(List.of(o1, o2, o3, o4));
    }
}
