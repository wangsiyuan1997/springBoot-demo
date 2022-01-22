package com.springboot5.controller;

import com.springboot5.bean.Tuser;
//import com.springboot5.serivce.lmpl.TuserService;
import com.springboot5.serivce.lmpl.TuserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @Date And @Time: 2022/1/11  15:46
 */
@Slf4j
@Controller
public class FormTestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TuserService tuserService;

    @ResponseBody
    @GetMapping("/query")
    public Tuser queryById(@RequestParam("id") Integer id){
        Tuser tuser = tuserService.queryById(id);
        return tuser;
    }



    @ResponseBody
    @GetMapping("/sql")
    public long countSql(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_book", long.class);
        return aLong;
    }




    @GetMapping("form_layouts")
    public String form_layouts() {

        return "form/form_layouts";
    }

    /**
     * 文件上传
     *
     * @author 汪思远
     * @creed: Talk is cheap,show me the code
     * @date 2022/1/11 16:33
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息:email{},username={},headerImg={},photos={}",
                email, username, headerImg.getSize(), photos.length);

        Random random = new Random();
        int i = random.nextInt();
        String s = String.valueOf(i);
        String substring = s.substring(3);
        //保存到磁盘/服务器
        if (!headerImg.isEmpty()) {

            //获取原始文件名
            String originalFilename = headerImg.getOriginalFilename() + substring;
            //springboot 封装好了 文件上传功能
            headerImg.transferTo(new File("C:\\Users\\ww\\Desktop\\src\\" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String s1 = photo.getOriginalFilename() + substring;
                    photo.transferTo(new File("C:\\Users\\ww\\Desktop\\src\\"+s1));
                }
            }
        }


        return "main";
    }
}
