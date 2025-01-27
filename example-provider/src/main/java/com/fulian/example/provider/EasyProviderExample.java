package com.fulian.example.provider;

import com.fulian.example.service.UserService;
import com.fulian.lianyurpc.registry.LocalRegistry;
import com.fulian.lianyurpc.server.HttpServer;
import com.fulian.lianyurpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.registry(UserService.class.getName(),UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
