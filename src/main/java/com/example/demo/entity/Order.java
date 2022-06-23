package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Getter
@Setter
    public class Order {
    @Id
    private String id;

    private String useremail;
    private String username;
    private String usersurname;
    private String ordertimeday;
    private String ordertimehour;
    private String restauranname;
}

