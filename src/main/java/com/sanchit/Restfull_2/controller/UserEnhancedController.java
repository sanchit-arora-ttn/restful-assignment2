package com.sanchit.Restfull_2.controller;

import com.sanchit.Restfull_2.models.User;
import com.sanchit.Restfull_2.models.UserEnhanced;
import com.sanchit.Restfull_2.service.UserEnhancedService;

import com.sanchit.Restfull_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserEnhancedController {
    @Autowired
    UserEnhancedService userEnhancedService;
    @Autowired
    UserService userService;


    //ques 5
    // A) MimeType Versioning
    @GetMapping(path = "/user", produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<List<User>> getUsersYamlV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user", produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<List<UserEnhanced>> getUsersYamlV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }

    // B) Request Parameter versioning
    @GetMapping(path = "/user", params = "version=1")
    public ResponseEntity<List<User>> getUsersParamsV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user", params = "version=2")
    public ResponseEntity<List<UserEnhanced>> getUsersParamsV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }

    // C) URI versioning
    @GetMapping(path = "/v1/user")
    public ResponseEntity<List<User>> getUsersUrlV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/v2/user")
    public ResponseEntity<List<UserEnhanced>> getUsersUrlV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }


    // D) Custom Header Versioning
    @GetMapping(path = "/user", headers = "X-API-VERSION=1")
    public ResponseEntity<List<User>> getUsersHeaderV1() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/user", headers = "X-API-VERSION=2")
    public ResponseEntity<List<UserEnhanced>> getUsersHeaderV2() {
        return new ResponseEntity<>(userEnhancedService.getUsers(), HttpStatus.OK);
    }

    //Ques-6
    @GetMapping(path = "v2/user/{id}")
    public ResponseEntity<EntityModel<UserEnhanced>> getUserById(@PathVariable String id) {
        UserEnhanced user = userEnhancedService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        //wrapping around Entity Model
        EntityModel<UserEnhanced> userEnhancedEntityModel = EntityModel.of(user);
        //creating HATEOAS link to fetch all topics
        Link topicsLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(UserEnhancedController.class).getAllTopics())
                .withRel("all-topics");

        userEnhancedEntityModel.add(topicsLink);

        return ResponseEntity.ok(userEnhancedEntityModel);
    }
    @GetMapping("/topics")
    public ResponseEntity<String> getAllTopics() {
        return ResponseEntity.ok("List of all topics");
    }

}
