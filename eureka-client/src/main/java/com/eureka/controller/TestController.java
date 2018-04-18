package com.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LI on 2018/4/16.
 */
@RestController
public class TestController {
    @Value("${server.port}")
    private Integer port;
    @RequestMapping(value = "/get")
    public List<String> get(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List l = new ArrayList();
        l.add("张三");
        l.add("李四");
        l.add(port+"");
        return l;
    }
}
