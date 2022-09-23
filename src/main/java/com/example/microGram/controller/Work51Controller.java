package com.example.microGram.controller;

import com.example.microGram.entity.User;
import com.example.microGram.work51.DataBaseConnectivity;
import com.example.microGram.work51.Service51;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Work51Controller {
    private final DataBaseConnectivity dbService;
    private final Service51 service;

    @GetMapping("/connect")
    public ResponseEntity<String> getConnection() {
        return new ResponseEntity<>(dbService.openConnection(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<String> createTable(){
        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<String> select() {
        return new ResponseEntity<>(service.shouldSelectData(), HttpStatus.OK);
    }

    @GetMapping("index")
    public ResponseEntity<String> select(User user){
        service.create(user);
        return new ResponseEntity<>(service.create(), HttpStatus.OK);
    }

}

