package com.fulian.example.provider;

import com.fulian.example.model.User;
import com.fulian.example.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
