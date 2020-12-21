package com.sun.controller;

import com.sun.entity.User;
import com.sun.entity.Users;
import com.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/user")//确立了API接口为/api/user
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getAllUser")//确立了此处API接口为/api/user/getALLUSer，return的数据将由此接口送往前端
    @ResponseBody
    private List<User> getAllUser(@RequestBody User user) {
        List<User> users =  userService.getAllUser(user);
        return users;
    }

    @RequestMapping("getOneUser")//用来判断登录
    @ResponseBody
    private String getOneUser(@RequestBody User user){
        String back = userService.getOneUser(user);
        return back;
    }

    @RequestMapping("/addUser")//用来注册的
    @ResponseBody
    private String addUser(@RequestBody User user) {
        String back =  userService.addUser(user);
        return back;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    private int updateUser(@RequestBody User user) {
        int users =  userService.updateUser(user);
        return users;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    private int deleteUser(@RequestBody User user) {
        int users =  userService.deleteUser(Long.valueOf(user.getId()));
        return users;
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    private List<Users> getAllUsers() {
        List<Users> users =  userService.getAllUsers();
        return users;
    }


}
