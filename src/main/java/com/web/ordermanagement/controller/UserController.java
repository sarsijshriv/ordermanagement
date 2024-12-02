package com.web.ordermanagement.controller;

import com.web.ordermanagement.model.Users;
import com.web.ordermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    Users createUser(@Valid @RequestBody Users userObject){
        return userService.createUser(userObject);
    }

    @PostMapping("/login")
    ResponseEntity<?> authenicateUser(@Valid @RequestBody Users userObject) {
        return userService.authenticateUser(userObject);
    }

    @PutMapping("/users/{id}")
    ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Users userObject){
        return userService.updateUser(id, userObject);
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}
