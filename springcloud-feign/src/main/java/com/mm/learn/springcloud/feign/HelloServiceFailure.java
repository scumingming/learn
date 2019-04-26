package com.mm.learn.springcloud.feign;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by wangmingming on 2019/4/26.
 */
@Service
public class HelloServiceFailure implements HelloService {



    @Override
    public String hello() {
        return "hello is failure,this is fallback";
    }
}
