package com.sanchit.Restfull_2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "User", description = "User entity contains basic user details")
public class User {
    @Schema(description = "Unique ID for the user of type String" )
    private String id;
    @Schema(description = "Name of the user of type String" )
    private String name;
    @Schema(description = "Age of the user of type String" )
    private int age;

    @JsonIgnore
    private String password;

    public User() {
    }


    public User(String id, String name, int age,String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }


    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
