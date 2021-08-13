package com.example.andchill.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class PurchasedMovie {
    @Id
    private String id;
    private Date purchaseDate;
}
