package com.springboot5.controller;

import com.springboot5.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Date And @Time: 2022/1/10  21:22
 */
@Controller
public class IndexController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/")
    public String login(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if (!StringUtils.isEmpty(user.getUsername())&& "123456".equals(user.getPassword())){
            session.setAttribute("user",user);
            //login 登录 重定向到 main.html,防止重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","密码账号错误，登录失败!");
            //回到登录页面
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

//        if (session.getAttribute("user")!=null){
//            return "main";
//        }else {
//            model.addAttribute("msg","请重新登录!");
//            //回到登录页面
//            return "login";
//        }
        String s = stringRedisTemplate.opsForValue().get("/main.html");
        String s2 = stringRedisTemplate.opsForValue().get("/basic_table");
        model.addAttribute("mianCount",s);
        model.addAttribute("tableCount",s2);

        return "main";
    }
}
