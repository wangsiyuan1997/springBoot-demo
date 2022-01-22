package com.atguigu.com.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Date And @Time: 2022/1/14  20:16
 */
@ConfigurationProperties("com.hello")
public class HelloProperties {

   private  String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private  String suffix;

}
