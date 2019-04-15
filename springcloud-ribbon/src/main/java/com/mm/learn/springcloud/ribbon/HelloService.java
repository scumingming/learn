package com.mm.learn.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangmingming on 2019/4/9.
 */
@RestController
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/ribbon")
    public String ribbonLoadBalance() {
        return restTemplate.getForObject("http://config_service/hello",String.class);
    }
}
