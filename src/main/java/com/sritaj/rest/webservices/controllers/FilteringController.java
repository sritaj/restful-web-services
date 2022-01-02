package com.sritaj.rest.webservices.controllers;

import com.sritaj.rest.webservices.beans.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBeans(){
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1_1", "value2_1", "value3_1"));
    }
}
