package com.mm.learn.springcloud.eureka.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangmingming on 2019/4/9.
 *
 * 测试发现使用 @EnableEurekaClient不能自动发现新增/删除的服务?????  最好使用 @EnableDiscoveryClient
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }

}
