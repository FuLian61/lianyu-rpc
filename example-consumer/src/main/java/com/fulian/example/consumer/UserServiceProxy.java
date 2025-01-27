package com.fulian.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fulian.example.model.User;
import com.fulian.example.service.UserService;
import com.fulian.lianyurpc.model.RpcRequest;
import com.fulian.lianyurpc.model.RpcResponse;
import com.fulian.lianyurpc.serializer.JdkSerializer;
import com.fulian.lianyurpc.serializer.Serializer;
import com.sun.org.apache.xpath.internal.operations.Variable;

import java.io.IOException;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {
    public User getUser(User user) {
        // 指定序列化器

        Serializer serializer = new JdkSerializer();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class<?>[]{User.class})
                .args(new Object[]{user})
                .build();

        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                  result = httpResponse.bodyBytes();
            }

            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
