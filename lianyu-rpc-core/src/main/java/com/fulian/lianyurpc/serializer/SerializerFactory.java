package com.fulian.lianyurpc.serializer;

import com.fulian.lianyurpc.spi.SpiLoader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化器工厂（用户获取序列化器对象）
 */
public class SerializerFactory {

    /**
     * 从 SPI 加载指定序列化器对象
     */
    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取示例
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class,key);
    }


}
