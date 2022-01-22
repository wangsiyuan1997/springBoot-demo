package com.springboot5.config;

import com.springboot5.interceptor.LoginInterceptor;
import com.springboot5.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Date And @Time: 2022/1/11  14:27
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截器配置
         registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");

         //拦截器访问Uri 获取 访问次数
                                                            //拦截所有请求
         registry.addInterceptor(redisUrlCountInterceptor).addPathPatterns("/**")
                 //排除静态资源
                 .excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");
    }

}
