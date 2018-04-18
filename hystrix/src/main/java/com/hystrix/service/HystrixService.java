package com.hystrix.service;

import com.hystrix.fallback.HystrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by LI on 2018/4/17.
 */
@Service
@FeignClient(value = "eureka-client",fallback = HystrixFallback.class)
public interface HystrixService {
    @RequestMapping("/get")
    public List get();
}
