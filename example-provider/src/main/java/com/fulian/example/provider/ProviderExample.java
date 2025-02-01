package com.fulian.example.provider;

import com.fulian.RpcApplication;
import com.fulian.example.service.UserService;
import com.fulian.lianyurpc.config.RegistryConfig;
import com.fulian.lianyurpc.config.RpcConfig;
import com.fulian.lianyurpc.model.ServiceMetaInfo;
import com.fulian.lianyurpc.registry.LocalRegistry;
import com.fulian.lianyurpc.registry.Registry;
import com.fulian.lianyurpc.registry.RegistryFactory;
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
        String serviceName = UserService.class.getName();
        LocalRegistry.registry(serviceName,UserServiceImpl.class);

        // 注册到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());

        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(rpcConfig.getServerPort());
    }
}
