package com.mm.learn.dubbo.server;


import com.mm.learn.dubbo.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangmingming on 2019/4/11.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:application.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        String hello = helloService.say();

        System.out.println(hello);

    }

}
