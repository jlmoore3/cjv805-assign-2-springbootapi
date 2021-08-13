package com.example.andchill.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class RentedMovie {
    @Id
    private String id;
    private Date purchaseDate;
    private Date expiryDate;
}
