package com.example.microGram.entity;


import lombok.Data;

@Data
public class User {
    private String accountName;
    private String email;
    private int id;
    private String password;
    private int counter;

    public User(String accountName, String email, int id, String password, int counter) {
        this.accountName = accountName;
        this.email = email;
        this.id = id;
        this.password = password;
        this.counter = counter;
    }
}
