package com.springBoot.study;

import ch.qos.logback.core.db.DBHelper;
import com.springBoot.study.bean.Pet;
import com.springBoot.study.bean.User;
import com.springBoot.study.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date And @Time: 2022/1/6  13:50
 */

//springboot 主程序
//@SpringBootApplication

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class MainApplication {

    public static void main(String[] args) {
        //返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //查看容器内的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //判断注册bean容器是不是单实例对象
//        User user1 = run.getBean(User.class);
//        User user2 = run.getBean(User.class);
//        System.out.println(user1 == user2);

//        MyConfig bean = run.getBean(MyConfig.class);
//
//        User userM1 = bean.user01();
//        User userM2 = bean.user01();
//        System.out.println(userM1 == userM2);
//
//        User user01 = run.getBean("user01", User.class);
//        Pet pet = run.getBean("pet", Pet.class);
//        System.out.println("用户的宠物："+ (user01.getPet() == pet));
//        System.out.println("==============================");
//        String[] names1 = run.getBeanNamesForType(User.class);
//        for (String s : names1) {
//            System.out.println(s);
//        }
//        DBHelper helper = run.getBean(DBHelper.class);
//        System.out.println(helper);



        boolean tom = run.containsBean("tom");
        System.out.println("组建中是否有:"+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("组建中是否有:"+user01);
    }
}
