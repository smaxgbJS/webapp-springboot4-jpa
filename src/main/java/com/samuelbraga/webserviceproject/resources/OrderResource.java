package com.samuelbraga.webserviceproject.resources;

import com.samuelbraga.webserviceproject.entities.Order;
import com.samuelbraga.webserviceproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable Long orderId) {
        Order order = orderService.findById(orderId);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Order>> findByClientId(@PathVariable Long clientId) {
        List<Order> orders = orderService.findByClientId(clientId);
        return ResponseEntity.ok().body(orders);
    }
}
