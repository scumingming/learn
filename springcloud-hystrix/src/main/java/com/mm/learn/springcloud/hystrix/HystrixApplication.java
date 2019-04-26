package com.mm.learn.springcloud.hystrix;

/**
 * Created by wangmingming on 2019/4/26.
 *
 *
 *
 1、  当满足一定的阀值的时候（默认10秒内超过20个请求次数）

 2、  当失败率达到一定的时候（默认10秒内超过50%的请求失败）

 3、  到达以上阀值，断路器将会开启

 4、  当开启的时候，所有请求都不会进行转发

 5、  一段时间之后（默认是5秒），这个时候断路器是半开状态，会让其中一个请求进行转发。如果成功，断路器会关闭，若失败，继续开启。重复4

 *
 *  ribbon熔断,见springcloud-ribbon2工程
 *  feign熔断,见springcloud-feign工程
 *
 *
 */
public class HystrixApplication {

}
