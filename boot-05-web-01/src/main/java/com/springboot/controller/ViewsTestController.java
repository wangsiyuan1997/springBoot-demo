package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date And @Time: 2022/1/10  21:03
 */
@Controller
public class ViewsTestController {

    @GetMapping("/viewTest")
    public String ViewTest1(Model model){
        model.addAttribute("msg","你好，世界");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
