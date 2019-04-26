package com.mm.learn.helloservice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangmingming on 2019/4/25.
 */

//@EnableEurekaClient

@SpringBootApplication
@RestController
public class HelloServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(HelloServiceApplication.class, args);

    }

    @Value("${server.port}")
    int port;

    @RequestMapping(value = "/hello")
    public String hello() {

        return "hello from " + port;
    }

}
