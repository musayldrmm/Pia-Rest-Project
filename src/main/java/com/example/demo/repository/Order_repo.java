package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Order_repo extends MongoRepository<Order, String> {
    List<Order> findByusername(String username);

}
