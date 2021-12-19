package com.sritaj.rest.webservices.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloWorld {

    private String userText;

    public HelloWorld(String userText){
        this.userText = userText;
    }
}
