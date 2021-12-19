package com.sritaj.rest.webservices.controllers;

import com.sritaj.rest.webservices.beans.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TestControllers {

    @GetMapping(path = "/hello-world")
    public String sampleTest(){
        return "Hello Test";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld sampleUserSpecidiedTest2(){
        return new HelloWorld("Hello World -     Bean Test");
    }
}
