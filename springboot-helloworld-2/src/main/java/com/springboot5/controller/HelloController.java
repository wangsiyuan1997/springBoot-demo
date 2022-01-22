package com.springboot5.controller;

import com.springboot5.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date And @Time: 2022/1/7  23:51
 */
@RestController
public class HelloController {
    @Autowired
    Person person;


    @RequestMapping("/yml")
    public Person test1(){
        return person;

    }

}
