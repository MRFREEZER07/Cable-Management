package com.cablemanagement.cable_management.service;

import java.util.List;

import com.cablemanagement.cable_management.entity.User;

public interface UserService {
    List<User> getUsers();
    User getUser(Long id);
    User addUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id);
    
}
