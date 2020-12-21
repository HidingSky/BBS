package com.sun.mapper;

import com.sun.entity.Huitie;
import com.sun.entity.Tiezi;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Mapper         //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface HuitieMapper {

    List<Huitie> getAllHuitie(Huitie huitie);

    int addHuitie(Huitie huitie);





}
