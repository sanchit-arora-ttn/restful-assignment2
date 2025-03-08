package com.sanchit.Restfull_2.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;


public class UserEnhanced extends RepresentationModel<UserEnhanced> {

    @Schema(description = "Unique ID for the user of type String" )
    private String id;

    @Schema(description = "First name of the user of type String" )
    private String firstName;

    @Schema(description = "First name of the user of type String" )
    private String lastName;

    @Schema(description = "Age of the user of type String" )
    private int age;


    private String password;

    public UserEnhanced(){}

    public UserEnhanced(String id, String firstName,String lastName , int age,String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }
}
