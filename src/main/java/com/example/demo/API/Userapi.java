package com.example.demo.API;

import com.example.demo.entity.User;
import com.example.demo.repository.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Userapi {
    @Autowired
    private User_repo user_repo;
    @PostMapping()
    public User add(@RequestBody User user){
return user_repo.save(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> alluser(){
        return ResponseEntity.ok(user_repo.findAll());
    }
}
