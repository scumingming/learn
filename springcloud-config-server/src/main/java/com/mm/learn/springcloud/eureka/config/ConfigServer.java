package com.mm.learn.springcloud.eureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wangmingming on 2019/4/9.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer {

    public static void main(String[] args) {

        SpringApplication.run(ConfigServer.class, args);

    }

}
