package com.hystrix.fallback;

import com.hystrix.service.HystrixService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务降级
 * Created by LI on 2018/4/17.
 */
@Component
public class HystrixFallback implements HystrixService{
    @Override
    public List get() {
        List list = new ArrayList();
        list.add("server timeout");
        return list;
    }
}
