package com.springboot5.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Date And @Time: 2022/1/10  21:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableField(exist = false)  //该注解是mybatis-plus 的 。代表该属性在表中不存在
    private String username;
    @TableField(exist = false)
    private String password;

    //一下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
