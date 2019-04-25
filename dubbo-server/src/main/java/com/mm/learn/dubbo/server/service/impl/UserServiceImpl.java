package com.mm.learn.dubbo.server.service.impl;

import com.mm.learn.dubbo.api.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by wangmingming on 2019/4/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Override
    public String getUserName(int id) {
        return null;
    }
}
