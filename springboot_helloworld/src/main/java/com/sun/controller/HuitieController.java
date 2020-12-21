package com.sun.controller;


import com.sun.entity.Huitie;
import com.sun.service.HuitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/huitie")
public class HuitieController {

    @Autowired
    private HuitieService huitieService;

    @RequestMapping("/getAllHuitie")
    @ResponseBody
    private List<Huitie> getAllHuitie(@RequestBody Huitie huitie){
        List<Huitie> huitieget = huitieService.getAllHuitie(huitie);
        return huitieget;
    }

    @RequestMapping("addHuitie")
    @ResponseBody
    private String addHuitie(@RequestBody Huitie huitie){
        String back = huitieService.addHuitie(huitie);
        return back;
    }



}
