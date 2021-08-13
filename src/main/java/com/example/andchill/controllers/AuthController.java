package com.example.andchill.controllers;

import com.example.andchill.CustomizedResponse;
import com.example.andchill.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

// Create an endpoint that will authenticate a user
    @PostMapping(value ="/auth", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity login(@RequestBody UserModel user) {
        System.out.println(user.getUsername());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            var customizedResponse = new CustomizedResponse("Login successful", null);
            System.out.println("Try block" + customizedResponse);
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            var customizedResponse = new CustomizedResponse("Bad credentials", null);
            System.out.println("Catch block" + customizedResponse);
            return new ResponseEntity(customizedResponse, HttpStatus.UNAUTHORIZED);
        }
    }

}
