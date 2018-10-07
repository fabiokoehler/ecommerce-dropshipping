package com.koehler.order.repository;

import com.koehler.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{'customer.id': ?0}")
    List<Order> findByCustomerId(String id);

    Order findByNumber(Long orderNumber);

}
