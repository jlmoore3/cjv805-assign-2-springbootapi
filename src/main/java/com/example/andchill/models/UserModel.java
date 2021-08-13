package com.example.andchill.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Document("Users")
public class UserModel {

    @Id
    private String id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String fName;
    @NotEmpty
    private String lName;
    @NotEmpty @Size(min=8, max=200)
    private String password;

    @Email
    private String email;

    @Field
    private String role = "customer";

    private ArrayList<RentedMovie> myRentedMovies;

    private ArrayList<PurchasedMovie> myPurchasedMovies;

    public UserModel() {
    }

    public UserModel(String id, String username, String fName, String lName, String password, String email, String role) {
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UserModel(String id, String username, String fName, String lName, String password, String role) {
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        System.out.println(role);
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
            this.role = role;
    }

    public ArrayList<RentedMovie> getMyRentedMovies() {
        return myRentedMovies;
    }

    public void setMyRentedMovies(ArrayList<RentedMovie> myRentedMovies) {
        this.myRentedMovies = myRentedMovies;
    }

    public ArrayList<PurchasedMovie> getMyPurchasedMovies() {
        return myPurchasedMovies;
    }

    public void setMyPurchasedMovies(ArrayList<PurchasedMovie> myPurchasedMovies) {
        this.myPurchasedMovies = myPurchasedMovies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", myRentedMovies=" + myRentedMovies +
                ", myPurchasedMovies=" + myPurchasedMovies +
                '}';
    }
}
