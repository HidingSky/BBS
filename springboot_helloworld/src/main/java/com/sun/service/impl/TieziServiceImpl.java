package com.sun.service.impl;


import com.sun.entity.Tiezi;
import com.sun.mapper.TieziMapper;
import com.sun.service.TieziService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.rmi.CORBA.Tie;
import java.util.List;

@Service(value = "tieziService")
@Transactional
public class TieziServiceImpl implements TieziService{

    @Resource
    private TieziMapper tieziMapper;

    @Override
    public List<Tiezi> getAllTiezi(Tiezi tiezi){
        return tieziMapper.getAllTiezi(tiezi);
    }


    @Override
    public String addTiezi(Tiezi tiezi) {
        tieziMapper.addTiezi(tiezi);
        return "发帖成功";
    }

}
