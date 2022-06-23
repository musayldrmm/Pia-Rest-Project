package com.example.demo.API;

import com.example.demo.emailsender;
import com.example.demo.entity.Order;
import com.example.demo.repository.Order_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/order")
public class Orderapi {
    @Autowired
private Order_repo OrderList;
    @Autowired
    private emailsender senderservice;
@GetMapping("/allorders")
public ResponseEntity<List<Order>> alluser(){
    return ResponseEntity.ok(OrderList.findAll());
}
@GetMapping("/{name}")
public ResponseEntity<Order> Userorders(@PathVariable String name){
    return ResponseEntity.ok(OrderList.findByUsername(name));
}
@PostMapping()
    public Order add(@RequestBody Order order){

    LocalDateTime now = LocalDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");

    order.setOrdertime(now.format(formatter));
    String email = order.getUseremail();
    String restoranadi=order.getRestauranName();
    String Time = order.getOrdertime();
    senderservice.sendEmail(email,"Rezervasyon başarılı"
            ,restoranadi+" adlı restoranda "+ Time+ " tarihinde yeriniz rezerve edildi");

    return OrderList.save(order);
    }
}
