package com.mm.learn.springcloud.turbine.dashbord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by wangmingming on 2019/4/26.
 *
 * 正常熔断监控只能监控一台,使用turbine可以监控多台
 *
 */
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class TurbineDashbordApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineDashbordApplication.class, args);
    }
}
