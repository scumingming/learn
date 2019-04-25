package com.mm.learn.dubbo.client.controller;

import com.mm.learn.dubbo.api.HelloService;

import javax.annotation.Resource;

/**
 * Created by wangmingming on 2019
 */
public class HelloController {

    @Resource
    HelloService helloService;



}
