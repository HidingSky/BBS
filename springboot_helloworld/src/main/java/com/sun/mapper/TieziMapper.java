package com.sun.mapper;

import com.sun.entity.Tiezi;
import com.sun.entity.User;
import com.sun.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Mapper         //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface TieziMapper {

    List<Tiezi> getAllTiezi(Tiezi tiezi);

    int addTiezi(Tiezi tiezi);





}
