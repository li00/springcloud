package com.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by LI on 2018/4/16.
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public List get(){
        return restTemplate.getForObject("http://eureka-client/get",List.class);
    }
}
