package com.example.test4spring;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyiruo
 * @Description
 * @Date 2021/1/21 下午5:22
 */
@Component
public class MyMap2 {
    public static Map map=null;
    private MyMap2() {
        map = new HashMap();
        map.put(1, "MyMap2"+System.currentTimeMillis() + Math.random());
        map.put(2, "MyMap2"+System.currentTimeMillis() + Math.random());
        map.put(3, "MyMap2"+System.currentTimeMillis() + Math.random());
        map.put(4, "MyMap2"+System.currentTimeMillis() + Math.random());
        map.put(5, "MyMap2"+System.currentTimeMillis() + Math.random());
    }
    public Map getMap() {
        return map;
    }
}
