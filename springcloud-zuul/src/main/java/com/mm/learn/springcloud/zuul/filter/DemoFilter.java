package com.mm.learn.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangmingming on 2019/4/26.
 */
@Component
public class DemoFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(DemoFilter.class);

    /**
     *
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Boolean isSuccess = (Boolean) ctx.get("isSuccess");  //判断上个filter是否通过,如果未通过直接返回,通过执行run
        if(null == isSuccess) return true;
        else return isSuccess;
    }

    /**
     * 过滤器的具体逻辑，这里只是将请求的URL简单些到日志中
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());

        String url = request.getRequestURL().toString();
        if(url.indexOf("api-hello") > 0) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("你是 api-hello,不让你过");
            ctx.set("isSuccess", false);
        } else {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        }

        logger.info(s);
        return null;
    }
}
