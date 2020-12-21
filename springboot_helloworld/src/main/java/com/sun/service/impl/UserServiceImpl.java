package com.sun.service.impl;

import com.sun.entity.User;
import com.sun.entity.Users;
import com.sun.mapper.UserMapper;
import com.sun.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> getAllUser(User user) {
        return userMapper.getAllUser(user);
    }

    @Override
    public  String getOneUser(User user){
        User userfind = userMapper.getOneUser(user);//使用用户名去数据库里搜索用户并返回用户
        if(userfind==null||userfind!=null&&!userfind.getPassword().equals(user.getPassword())){//如果返回为空（没注册，数据库里没有）
            //或者在数据库里按名字搜到了用户但是密码却和从前端传来的用户的密码不匹配
            return "用户名或密码错误或暂未注册";
        }

        else{
            return "登录成功";
        }
    }

    @Override
    public String addUser(User user) {
        User userone = userMapper.getOneUser(user);
        if(userone!=null){
            return "该用户名已被注册";

        }
        else {

            userMapper.addUser(user);
            return "注册成功";
        }

    }



    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
