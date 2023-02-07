package com.cablemanagement.cable_management.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cablemanagement.cable_management.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{userId}")
    public ResponseEntity<User> getGrade(@PathVariable Long userId) {
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(Long id){
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,Long id){
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
