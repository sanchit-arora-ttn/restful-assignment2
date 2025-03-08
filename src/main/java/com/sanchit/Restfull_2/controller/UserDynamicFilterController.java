package com.sanchit.Restfull_2.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sanchit.Restfull_2.service.UserDynamicFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDynamicFilterController {
    @Autowired
    UserDynamicFilterService userService;
    //Ques 4
    @GetMapping("/userDynamicFilter")
    public MappingJacksonValue filter(){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userService.getUsers());// here given user list
        PropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserEnhancedFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
