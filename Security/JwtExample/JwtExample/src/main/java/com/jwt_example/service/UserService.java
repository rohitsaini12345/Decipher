package com.jwt_example.service;

import com.jwt_example.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store=new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Rohit Saini","rohit@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Naksh Saini","naksh@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Mohit Saini","mohit@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Yuvi Saini","yuvi@gmail.com"));

    }

    public List<User> getUsers() {
        return this.store;
    }
}
