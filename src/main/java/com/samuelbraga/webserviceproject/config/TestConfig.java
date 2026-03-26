package com.samuelbraga.webserviceproject.config;

import com.samuelbraga.webserviceproject.entities.Category;
import com.samuelbraga.webserviceproject.entities.Order;
import com.samuelbraga.webserviceproject.entities.Product;
import com.samuelbraga.webserviceproject.entities.User;
import com.samuelbraga.webserviceproject.enums.OrderStatus;
import com.samuelbraga.webserviceproject.repositories.CategoryRepository;
import com.samuelbraga.webserviceproject.repositories.OrderRepository;
import com.samuelbraga.webserviceproject.repositories.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

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

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(List.of(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));
    }
}
