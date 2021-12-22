package com.sritaj.rest.webservices.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private Integer id;

    @Size(min = 2, message = "User name should be min 2 characters")
    private String name;

    @Past
    private Date dateOfBirth;
}
