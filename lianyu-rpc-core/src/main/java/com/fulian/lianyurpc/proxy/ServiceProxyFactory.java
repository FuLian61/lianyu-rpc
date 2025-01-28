package com.fulian.lianyurpc.proxy;

import com.fulian.RpcApplication;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用户创建代理工厂）
 */
public class ServiceProxyFactory {

    public static <T> T getProxy(Class<T> serviceClass){
        if (RpcApplication.getRpcConfig().isMock()){
            return getMockProxy(serviceClass);
        }

        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class[]{serviceClass},new ServiceProxy());
    }

    public static <T> T getMockProxy(Class<T> serviceClass){
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new MockServiceProxy()
        );
    }
}
