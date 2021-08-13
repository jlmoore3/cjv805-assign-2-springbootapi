package com.example.andchill.controllers;

import com.example.andchill.CustomizedResponse;
import com.example.andchill.models.UserModel;
import com.example.andchill.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        var customizedResponse = new CustomizedResponse("GET all users", service.getUsers());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    /* Create an endpoint that retrieves a specific customer */
    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String id) {
        var customizedResponse = new CustomizedResponse("GET user with ID: "+id, Collections.singletonList(service.getUserById(id)));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


    /* Create an endpoint that allows users to register */
    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        var customizedResponse = new CustomizedResponse("POST. New user created: ", Collections.singletonList(service.addUser(userModel)));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity putUser(@PathVariable("id") String id, @RequestBody UserModel newUser) {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse("Update user with id "+id, Collections.singletonList(service.editUser(id, newUser)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }


}
