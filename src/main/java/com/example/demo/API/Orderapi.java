package com.example.demo.API;

import com.example.demo.entity.Order;
import com.example.demo.repository.Order_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class Orderapi {
    @Autowired
private Order_repo OrderList;
@GetMapping("/allorders")
public ResponseEntity<List<Order>> alluser(){
    return ResponseEntity.ok(OrderList.findAll());
}
@GetMapping("/{id}")
public ResponseEntity<Order> Userorders(@PathVariable String id){
    return ResponseEntity.ok(OrderList.findByUserid(id));
}
@PostMapping()
    public Order add(@RequestBody Order order){

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");


    order.setOrdertime(now.format(formatter));
    return OrderList.save(order);
    }
}
