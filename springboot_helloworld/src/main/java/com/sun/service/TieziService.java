package com.sun.service;

import com.sun.entity.Tiezi;

import java.util.List;

public interface TieziService {

    List<Tiezi> getAllTiezi(Tiezi tiezi);

    String addTiezi(Tiezi tiezi);

}
