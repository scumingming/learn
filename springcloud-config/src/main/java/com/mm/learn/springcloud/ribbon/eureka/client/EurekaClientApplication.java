package com.mm.learn.springcloud.ribbon.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangmingming on 2019/4/9.
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
//@EnableAutoConfiguration
public class EurekaClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }

}
