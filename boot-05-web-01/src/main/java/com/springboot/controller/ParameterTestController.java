package com.springboot.controller;

import com.springboot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**测试参数的Controller
 * @Date And @Time: 2022/1/8  23:45
 */


@RestController
public class ParameterTestController {


    @PostMapping("/saveuser")
    public Person saveUser(Person person){

        return person;
    }





    @RequestMapping(value = "/car/{id}/owner/{username}",method = RequestMethod.GET)
    public Map<String ,Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String ,String> pv,
                                      @RequestHeader("Host") String getHost,
                                      @RequestHeader Map<String ,String> headers,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("hobby")List<String> hobby){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        map.put("pv",pv);
        map.put("getHost",getHost);
        map.put("headers",headers);
        map.put("age",age);
        map.put("hobby",hobby);
//        map.put("cookie",cookie);


        return map;
    }

    @PostMapping("/save")
    public Map<String ,Object> postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content", URLDecoder.decode(content));

        return map;
    }


    // 矩阵变量的语法 /cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map cars(@MatrixVariable("low") Integer low,
                    @MatrixVariable("brand")  List<String> brand,
                    @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);

        return map;
    }

    //矩阵变量用法  /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossId,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empId){
        Map<String, Object> map = new HashMap<>();
        map.put("bossId",bossId);
        map.put("empId",empId);
        return map;
    }
}
