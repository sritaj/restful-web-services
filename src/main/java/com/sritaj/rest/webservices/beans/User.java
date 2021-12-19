package com.sritaj.rest.webservices.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Date dateOfBirth;
}
