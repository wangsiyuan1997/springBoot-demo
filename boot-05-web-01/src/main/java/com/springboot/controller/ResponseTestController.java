package com.springboot.controller;

import com.springboot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Date And @Time: 2022/1/10  12:41
 */
@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/Person")
    public Person getPerson(){
        Person person = new Person();
        person.setUserName("zhangsan");
        person.setAge(11);
        person.setBirth(new Date());
        return  person;
    }
}
