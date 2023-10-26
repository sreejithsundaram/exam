package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<cart, String> {
    
}
