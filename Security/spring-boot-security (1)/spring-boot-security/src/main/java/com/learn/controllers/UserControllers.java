package com.learn.controllers;

import com.learn.models.User;
import com.learn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    private UserService userService;


    //all users
    @GetMapping("/")
    public List<User> getAllUser() {
        return this.userService.getAllUser();
    }

    //return single user
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //add user
    @PostMapping("/")
    public User add(@RequestBody User user){

        return this.userService.addUser(user);
    }

}
