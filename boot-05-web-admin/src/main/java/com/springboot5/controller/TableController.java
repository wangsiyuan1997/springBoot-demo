package com.springboot5.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot5.bean.User;
import com.springboot5.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date And @Time: 2022/1/10  22:12
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
//        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes rd){
        userService.removeById(id);
        rd.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        List<User> list = userService.list();
//        model.addAttribute("users",list);
        //分页数据
        Page<User> userPage = new Page<>(pn,10);

        userPage.setMaxLimit(5L);
        Page<User> pages = userService.page(userPage, null);

        model.addAttribute("users",pages);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
