package com.mm.learn.springcloud.ribbon2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wangmingming on 2019/4/26.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon/hello")
    public String hello() {
        return "ribbon: " +  helloService.hello();
    }

}
