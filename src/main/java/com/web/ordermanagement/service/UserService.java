package com.web.ordermanagement.service;

import com.web.ordermanagement.configurations.JwtConfiguration;
import com.web.ordermanagement.model.Users;
import com.web.ordermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtConfiguration jwtConfiguration;


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
        user.setPassword(passwordEncoder.encode(customerObject.getPassword()));
        user.setName(customerObject.getName());
        user.setEmail(customerObject.getEmail());
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

    public ResponseEntity<?> authenticateUser(Users userObject) {
        if(userObject.getEmail() == null || userObject.getPassword() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or password is missing");
        Optional<Users> user = userRepository.findByEmail(userObject.getEmail());
        if(user.isPresent()){
            if(passwordEncoder.matches(userObject.getPassword(), user.get().getPassword()))
                return ResponseEntity.ok(jwtConfiguration.generateToken(user.get().getEmail()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username or password is incorrect");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username or password is incorrect");
    }
}
