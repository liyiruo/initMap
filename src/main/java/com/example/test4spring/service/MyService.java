package com.example.test4spring.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author liyiruo
 * @Description  依据单例模式
 * @Date 2021/1/22 上午11:13
 */
@Component
public class MyService {
    private static volatile HashMap map;
    private MyService() {
    }
    /**
     * 获取map
     * @return
     */
    public HashMap getMap() {
        if (map == null) {
            synchronized (this) {
                if (map == null) {
                    map = new HashMap<>();
                    map.put("key1", System.currentTimeMillis() + Math.random());
                    map.put("key2", System.currentTimeMillis() + Math.random());
                    map.put("key3", System.currentTimeMillis() + Math.random());
                }
            }
        }
        return map;
    }

    /**
     * 清空map
     */
    public void setMapEqNull() {
        map = null;
    }
}
