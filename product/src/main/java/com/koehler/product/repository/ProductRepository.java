package com.koehler.product.repository;

import com.koehler.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(@Param("name") String name);

}
