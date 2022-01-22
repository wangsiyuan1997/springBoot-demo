package com.springboot5.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Date And @Time: 2022/1/12  15:19
 */
@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("监听器初始化完成。。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听器销毁完成。。。。");
    }
}
