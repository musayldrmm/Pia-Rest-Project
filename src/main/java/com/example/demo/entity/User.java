package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Document
@Getter
@Setter
public class    User {
    @Id
    private String id;
    private String adi;
    private String soyadi;
    @Indexed(unique=true)
    private String email;
    private String password;


}
