package com.fulian.lianyurpc.proxy;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用户创建代理工厂）
 */
public class ServiceProxyFactory {

    public static <T> T getProxy(Class<T> serviceClass){
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class[]{serviceClass},new ServiceProxy());
    }

}
