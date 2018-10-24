package com.koehler.order.controller;

import com.koehler.model.Order;
import com.koehler.order.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/order/{id}")
    public ResponseEntity getOrder(@PathVariable String id) {

        Optional<Order> order = repository.findById(id);

        if (order.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(order.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/order")
    Order newOrder(@RequestBody Order newOrder) {
        return repository.save(newOrder);
    }

    @DeleteMapping("/order")
    public void delete() {
        repository.deleteAll();
    }
}
