package com.mm.learn.dubbo.server.service.impl;

import com.mm.learn.dubbo.api.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by wangmingming on 2019/4/11.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "hello";
    }
}
