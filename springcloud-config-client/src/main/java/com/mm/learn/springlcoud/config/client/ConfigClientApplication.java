package com.mm.learn.springlcoud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangmingming on 2019/4/25.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${name}")
    String hello;


    @RequestMapping(value = "/hello")
    public String hello() {
        return this.hello;
    }

}
