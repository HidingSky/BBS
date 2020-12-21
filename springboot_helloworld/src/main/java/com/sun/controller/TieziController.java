package com.sun.controller;


import com.sun.entity.Tiezi;
import com.sun.service.TieziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.rmi.CORBA.Tie;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/tiezi")
public class TieziController {

    @Autowired
    private TieziService tieziService;

    @RequestMapping("/getAllTiezi")
    @ResponseBody
    private List<Tiezi> getAllTiezi(@RequestBody Tiezi tiezi){
        List<Tiezi> tieziget = tieziService.getAllTiezi(tiezi);
        return tieziget;
    }

    @RequestMapping("addTiezi")
    @ResponseBody
    private String addTiezi(@RequestBody Tiezi tiezi) {
        String back = tieziService.addTiezi(tiezi);
        return back;
    }





}
