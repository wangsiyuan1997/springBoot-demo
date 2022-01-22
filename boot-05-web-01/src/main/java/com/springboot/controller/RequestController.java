package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date And @Time: 2022/1/9  0:32
 */
@Controller
public class RequestController {


    @GetMapping("/params")
    public String testParam(Map<String , Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){

        map.put("mapKey","mapValue");
        model.addAttribute("modelKey","modelValue");
        request.setAttribute("hello","world");
        response.addCookie(new Cookie("c1","v1"));
        return "forward:/success";
    }


    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功！");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String ,Object> success(@RequestAttribute(value = "msg",required = false) String msg,
                                       HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();
        map.put("msg",msg);
        Object mapKey = request.getAttribute("mapKey");
        Object modelKey = request.getAttribute("modelKey");
        Object requestAttribute = request.getAttribute("hello");

        map.put("mapKey",mapKey);
        map.put("modelKey",modelKey);
        map.put("requestAttribute",requestAttribute);

        return map;
    }
}
