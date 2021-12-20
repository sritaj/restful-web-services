package com.sritaj.rest.webservices.dao;

import com.sritaj.rest.webservices.beans.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Sritaj", new Date()));
        users.add(new User(2, "Anusha", new Date()));
        users.add(new User(3, "Ankit", new Date()));
    }

    public List<User> findAll(){
        return  users;
    }

    public User saveUser(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return  user;
    }

    public User findUser(int id){
        for (User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
                if(user.getId() == id){
                    iterator.remove();
                    return user;
                }
        }
        return null;
    }
}
