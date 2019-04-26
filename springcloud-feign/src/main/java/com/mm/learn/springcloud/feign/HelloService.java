package com.mm.learn.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangmingming on 2019/4/26.
 * FeignClient 指定 hello-service服务
 * RequestMapping 指定url
 */
@FeignClient(value = "hello-service", fallback = HelloServiceFailure.class)
public interface HelloService {

    @RequestMapping(value = "/hello")
    String hello();

}
