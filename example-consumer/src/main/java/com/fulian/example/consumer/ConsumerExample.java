package com.fulian.example.consumer;

import com.fulian.lianyurpc.config.RpcConfig;
import com.fulian.lianyurpc.utils.ConfigUtils;

/**
 * 消费者示例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // 配置文件读取
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
