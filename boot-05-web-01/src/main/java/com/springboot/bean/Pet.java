package com.springboot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Date And @Time: 2022/1/9  20:19
 */
@Component
public class Pet {
    private String name;
    private String age;

    public Pet() {
    }

    public Pet(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
