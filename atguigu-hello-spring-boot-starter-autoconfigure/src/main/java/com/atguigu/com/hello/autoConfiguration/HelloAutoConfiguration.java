package com.atguigu.com.hello.autoConfiguration;

import com.atguigu.com.hello.bean.HelloProperties;
import com.atguigu.com.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date And @Time: 2022/1/14  20:20
 */

@Configuration
@EnableConfigurationProperties(HelloProperties.class) //开启springBoot 之后 将HelloProperties 自动加载到容器中
public class HelloAutoConfiguration {

    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService HelloService(){
        return new HelloService();
    }
}
