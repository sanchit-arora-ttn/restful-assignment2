package com.sanchit.Restfull_2.controller;

import com.sanchit.Restfull_2.service.SayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Ques-1

@RestController
public class SayHelloController {
    @Autowired
    private SayHelloService service;

    SayHelloController(SayHelloService service) {
        this.service = service;
    }

    @GetMapping("/hello/{username}")
    public ResponseEntity<String> sayHello(@PathVariable String username) {
        String message = service.getHello();
        return new ResponseEntity<>(message + " " + username, HttpStatus.OK);
    }
}
