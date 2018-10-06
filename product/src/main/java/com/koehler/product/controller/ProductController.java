package com.koehler.product.controller;

import com.koehler.product.model.Product;
import com.koehler.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/product")
    public ResponseEntity all() {

        List<Product> products = repository.findAll();

        if (products == null || products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteStudent(@PathVariable String id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/product")
    public void delete() {
        repository.deleteAll();
    }
}
