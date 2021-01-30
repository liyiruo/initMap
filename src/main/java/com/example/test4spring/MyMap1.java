package com.example.test4spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyiruo
 * @Description
 * @Date 2021/1/21 下午5:19
 */
@Component
@Scope
public class MyMap1 implements InitializingBean, ServletContextAware {
    public  Map map;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("9999==================>");
        map = new HashMap();
        map.put(1, "MyMap1"+System.currentTimeMillis() + Math.random());
        map.put(2, "MyMap1"+System.currentTimeMillis() + Math.random());
        map.put(3, "MyMap1"+System.currentTimeMillis() + Math.random());
        map.put(4, "MyMap1"+System.currentTimeMillis() + Math.random());
        map.put(5, "MyMap1"+System.currentTimeMillis() + Math.random());
    }
    private MyMap1() {
    }
    public  Map getMap() {
        return map;
    }
    @Override
    public void setServletContext(ServletContext servletContext) {
    }
}
