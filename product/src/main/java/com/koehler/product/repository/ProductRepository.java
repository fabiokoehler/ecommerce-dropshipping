package com.koehler.product.repository;

import com.koehler.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(@Param("name") String name);

}
