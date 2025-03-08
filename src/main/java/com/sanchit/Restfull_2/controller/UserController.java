package com.sanchit.Restfull_2.controller;


import com.sanchit.Restfull_2.models.User;
import com.sanchit.Restfull_2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Ques-2

@RestController
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // POST Method : this accepts XML Input
    // will create user with password
    @PostMapping(path = "/user",consumes = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Save the user", description = "Creates a new user and saves it in the system.")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    // GET Method : this returns XML Response
    // will not give password as we used @JsonIgnore
    @GetMapping(path = "/user", produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Get list of users", description = "Fetches all users stored in the system.")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    // will not give password as we used @JsonIgnore
    @GetMapping(path = "user/{id}")
    @Operation(summary = "Get user by ID", description = "Fetches a specific user based on their ID.")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    @Operation(summary = "Update a user", description = "Updates an existing user with new details.")
    public ResponseEntity<String> createUser(@PathVariable String id ,@RequestBody User user) {
        service.updateUser(id,user);
        return new ResponseEntity<>("User Updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    @Operation(summary = "Delete a user", description = "Removes a user from the system based on their ID.")
    public ResponseEntity<String> deleateUser(@PathVariable String id ) {
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }

}
