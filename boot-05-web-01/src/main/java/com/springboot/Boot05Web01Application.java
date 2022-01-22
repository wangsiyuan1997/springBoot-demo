package com.springboot;

import com.springboot.bean.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springboot")
public class Boot05Web01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Boot05Web01Application.class, args);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {

            System.out.println(name);
        }
    }

}
