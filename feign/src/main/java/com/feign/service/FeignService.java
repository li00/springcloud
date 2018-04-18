package com.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by LI on 2018/4/17.
 */
@FeignClient("eureka-client")
@Service
public interface FeignService {
    @RequestMapping("/get")
    public List get();
}
