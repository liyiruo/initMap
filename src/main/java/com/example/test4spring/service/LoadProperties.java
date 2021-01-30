package com.example.test4spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * @author liyiruo
 * @Description
 * @Date 2021/1/22 下午4:33
 */
@Slf4j
@Component
public class LoadProperties {
    private static final String CONFIG_PATH="/Users/liyiruo/IdeaProjects/test4spring/src/main/resources/select.properties";
    public static Map getData() throws IOException {
        Properties properties = new Properties();
        /**
         * 第一种方式
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_PATH));
        properties.load(bufferedReader);
        /**
         * 第二中方式
         */
       /* InputStream in = LoadProperties.class.getClassLoader().getResourceAsStream("select.properties");
        properties.load(in);*/
        // 获取key对应的value值
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        Map<String, Map<String, String>> codeMap = new HashMap<>();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            String key = (String) next.getKey();
            String value = (String) next.getValue();
            log.info("{}<===>{}", key, value);
            String[] strings = key.split("\\.");
            String code = strings[0];
            String mykey = strings[1];
            Map<String, String> keyMap = codeMap.getOrDefault(code, new HashMap<>());
            keyMap.put(mykey, value);
            codeMap.put(code, keyMap);
        }
        return codeMap;
    }

    public static void main(String[] args) throws IOException {
        LoadProperties loadProperties = new LoadProperties();
        Map map = getData();
        log.info("result====>{}", map);

    }
}
