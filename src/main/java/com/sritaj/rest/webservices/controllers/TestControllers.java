package com.sritaj.rest.webservices.controllers;

import com.sritaj.rest.webservices.beans.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("")
public class TestControllers {

    @Autowired
    private MessageSource messageSource;

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

    // Using Locale as attribute 
//    @GetMapping(path = "/hello-world-internationalized")
//    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required=false) Locale locale){
//        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
//    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message", null, "Default message", LocaleContextHolder.getLocale());
    }
}
