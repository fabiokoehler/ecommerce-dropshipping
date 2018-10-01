package com.koehler.order.controller;

import com.koehler.order.model.Order;
import com.koehler.order.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository repository;

    OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/order")
    public ResponseEntity all(@RequestHeader(value="Authorization") String auth) {

        List<Order> orders = repository.findByCustomerId(JwtUtils.getUserId(auth));

        if (orders == null || orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findByCustomerId(JwtUtils.getUserId(auth)));
        }
    }

    @PostMapping("/order")
    Order newOrder(@RequestBody Order newOrder) {
        return repository.save(newOrder);
    }
}
