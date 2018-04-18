package com.ribbon.controller;

import com.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LI on 2018/4/16.
 */
@RestController
public class RibbonController {
    @Autowired
    private RibbonService service;

    @RequestMapping(value = "/get")
    public List get(){
        return service.get();
    }
}
