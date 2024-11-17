package com.web.ordermanagement.service;

import com.web.ordermanagement.model.Users;
import com.web.ordermanagement.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> getUserById(Long id) {
        Optional<Users> user = userRepository.findById(id);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    public Users createUser(Users customerObject) {
        Users user = new Users();
        user.setName(customerObject.getName());
        user.setAddress(customerObject.getAddress());
        user.setDate_of_birth(customerObject.getDate_of_birth());
        user.setCreated_at(Instant.now());
        user.setUpdated_at(Instant.now());
        userRepository.save(user);
        return user;
    }

    public ResponseEntity<?> deleteUser(Long id) {
        Optional<Users> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user does not exists");
    }

    public ResponseEntity<?> updateUser(Long id, Users userObject) {
        Optional<Users> user = userRepository.findById(id);
        if(user.isPresent()){
            Users updateUser = user.get();
            updateUser.setName(userObject.getName());
            updateUser.setAddress(userObject.getAddress());
            updateUser.setDate_of_birth(userObject.getDate_of_birth());
            updateUser.setUpdated_at(Instant.now());
            userRepository.save(updateUser);
            return ResponseEntity.accepted().body(updateUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
