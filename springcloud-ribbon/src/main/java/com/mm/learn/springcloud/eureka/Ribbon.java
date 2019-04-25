package com.mm.learn.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangmingming on 2019/4/9.
 */
@SpringCloudApplication
@EnableDiscoveryClient
public class Ribbon {

    public static void main(String[] args) {
        SpringApplication.run(Ribbon.class,args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
