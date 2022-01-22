package com.atguigu.com.hello.service;

import com.atguigu.com.hello.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Date And @Time: 2022/1/14  20:15
 */
public class HelloService {
    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String username){
        return helloProperties.getPrefix()+username+helloProperties.getSuffix();
    }
}
