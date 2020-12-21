package com.sun.service.impl;


import com.sun.entity.Huitie;
import com.sun.mapper.HuitieMapper;
import com.sun.service.HuitieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "huitieService")
@Transactional
public class HuitieServiceImpl implements HuitieService {

    @Resource
    private HuitieMapper huitieMapper;

    @Override
    public List<Huitie> getAllHuitie(Huitie huitie){//虽然叫getall，
        // 但是是按tiezi的id来查的，因为帖子的内部回帖内容必须与帖子本身绑定。
        return huitieMapper.getAllHuitie(huitie);
    }

    @Override
    public String addHuitie(Huitie huitie){
        huitieMapper.addHuitie(huitie);
        return "回复成功";
    }






}
