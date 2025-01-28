package com.fulian.example.provider;

import com.fulian.RpcApplication;
import com.fulian.example.service.UserService;
import com.fulian.lianyurpc.registry.LocalRegistry;
import com.fulian.lianyurpc.server.HttpServer;
import com.fulian.lianyurpc.server.VertxHttpServer;

/**
 * 服务提供者示例
 */
public class ProviderExample {
    public static void main(String[] args) {
        // 全局配置对象加载
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.registry(UserService.class.getName(),UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
