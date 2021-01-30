package com.example.test4spring.controller;

import com.example.test4spring.MyMap1;
import com.example.test4spring.MyMap2;
import com.example.test4spring.pojo.Student;
import com.example.test4spring.service.LoadProperties;
import com.example.test4spring.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * @author liyiruo
 * @Description
 * @Date 2021/1/21 下午6:49
 */
@Controller
public class TestController {
    @Autowired
    MyMap2 map2;
    @Autowired
    MyMap1 map1;
    @Autowired
    MyService service;


    @RequestMapping("/get2")
    @ResponseBody
    public Map getMap2() {
        return map2.getMap();
    }

    @RequestMapping("/get1")
    @ResponseBody
    public Map getMap1() {
        return map1.getMap();
        // return null;
    }

    @ResponseBody
    @RequestMapping("/clear")
    public Map clear() {
        service.setMapEqNull();
        return service.getMap();
    }

    @ResponseBody
    @RequestMapping("/getfull")
    public Map getfull() {
        return service.getMap();
    }

    @ResponseBody
    @RequestMapping("/getDataBycode/{code}")
    public Map getDataBycode(@PathVariable("code") String code) throws IOException {
        Map map = LoadProperties.getData();
        return (Map) map.getOrDefault(code, null);
    }

    public Student[] get() {
        Student[] students = new Student[100];
        students[0] = new Student();
        return null;
    }

    public void get2() {
    }
}
