package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Order_repo extends MongoRepository<Order, String> {
    Order findByUsername(String id);
}
