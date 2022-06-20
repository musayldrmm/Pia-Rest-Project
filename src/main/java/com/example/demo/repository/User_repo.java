package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_repo extends MongoRepository<User,String> {
    User findByEmail(String email);
    User findByPassword(String password);
}
