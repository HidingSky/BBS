package com.sun.mapper;

import com.sun.entity.User;
import com.sun.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Mapper         //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserMapper {

    List<User> getAllUser(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);

    List<Users> getAllUsers();

    User getOneUser(User user);



}
