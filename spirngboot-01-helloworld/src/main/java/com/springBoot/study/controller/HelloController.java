package com.springBoot.study.controller;

import com.springBoot.study.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date And @Time: 2022/1/6  13:51
 */
//是Controller注解与 ResponseBody 注解   合体
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String test1(){
        return "Hello Spring Boot 2 !"+"你好！！！！！！！";
    }

    @RequestMapping("/car")
    public Car car(){

        return car;
    }
}
