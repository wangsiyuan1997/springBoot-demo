package com.springBoot.study.config;

import ch.qos.logback.core.db.DBHelper;
import com.springBoot.study.bean.Car;
import com.springBoot.study.bean.Pet;
import com.springBoot.study.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Date And @Time: 2022/1/7  13:42
 */
//@Import({User.class,DBHelper.class})
@Configuration(proxyBeanMethods = false)
//方式二 用EnableConfigurationProperties 在配置类中 将javabean 注册到容器中
@EnableConfigurationProperties(Car.class)
public class MyConfig {
    @Bean(name = "tom")
    public Pet pet (){
        Pet tom = new Pet("tom2");
        return tom;
    }

    @ConditionalOnBean(name ="tom")
    @Bean
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
//        zhangsan.setPet(pet());
        return zhangsan;
    }


}
