package com.web.ordermanagement.controller;

import com.web.ordermanagement.model.Users;
import com.web.ordermanagement.service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    Users createUser(@RequestBody Users userObject){
        return userService.createUser(userObject);
    }

    @PostMapping("/login")
    ResponseEntity<?> authenicateUser(@RequestBody Users userObject) {
        return userService.authenticateUser(userObject);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Users userObject){
        return userService.updateUser(id, userObject);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
