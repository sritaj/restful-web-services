package com.sritaj.rest.webservices.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.sritaj.rest.webservices.beans.User;
import com.sritaj.rest.webservices.dao.UserDaoService;
import com.sritaj.rest.webservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/getAllUsers")
    public List<User> returnAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path = "getuser/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        User user =  userDaoService.findUser(id);
        if(user == null){
            throw new UserNotFoundException("Specified user with id " + id + " is not found");
        }

        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers  = linkTo(methodOn(this.getClass()).returnAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping(path = "createuser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser =  userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "deleteuser/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteUser(id);

        if(user == null){
            throw new UserNotFoundException("Specified user with id " + id + " is not found");
        }

    }
}
