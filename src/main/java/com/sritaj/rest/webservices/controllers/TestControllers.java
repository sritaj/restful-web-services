package com.sritaj.rest.webservices.controllers;

import com.sritaj.rest.webservices.beans.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TestControllers {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello Test";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello World -     Bean Test");
    }

    @GetMapping(path = "/hello-world-pathvariable/{text}")
    public HelloWorld helloWorldPathVariable(@PathVariable String text){
        return new HelloWorld(String.format("Hello World By - %s", text));
    }
}
