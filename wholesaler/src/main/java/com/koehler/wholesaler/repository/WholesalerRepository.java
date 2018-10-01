package com.koehler.wholesaler.repository;

import com.koehler.wholesaler.model.Wholesaler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WholesalerRepository extends MongoRepository<Wholesaler, String> {


}
