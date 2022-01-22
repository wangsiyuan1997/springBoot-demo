package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Date And @Time: 2022/1/14  17:38
 */
@Component
@ConfigurationProperties("person")
@Data
public class Person {
    private String name;
    private Integer age;
}
