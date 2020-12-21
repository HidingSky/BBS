package com.sun.service;

import com.sun.entity.User;
import com.sun.entity.Users;

import java.util.List;

public interface UserService {

    List<User> getAllUser(User user);

    String addUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);

    List<Users> getAllUsers();

    String getOneUser(User user);

}
