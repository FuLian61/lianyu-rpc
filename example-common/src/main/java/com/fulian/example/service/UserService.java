package com.fulian.example.service;

import com.fulian.example.model.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 新方法，测试mock
     * @return
     */
    default short getNumber(){
        return 1;
    }
}
