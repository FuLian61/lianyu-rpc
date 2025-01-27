package com.fulian.example.consumer;

import com.fulian.example.model.User;
import com.fulian.example.service.UserService;
import com.fulian.lianyurpc.proxy.ServiceProxy;
import com.fulian.lianyurpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        User user = new User();
        user.setName("fulian");
//        // 静态代理
//        UserService userService = new UserServiceProxy();

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        }else{
            System.out.println("user == null");
        }
    }
}
