package com.mm.learn.springcloud.ribbon2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by wangmingming on 2019/4/26.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFailureMethod")
    public String hello() {
        return restTemplate.getForObject("http://hello-service/hello",String.class);
    }

    public String helloFailureMethod() {
        return restTemplate.getForObject("http://hello-service/hello",String.class);
    }

}
