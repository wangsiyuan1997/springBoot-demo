package com.springboot5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot5.bean.User;
import org.springframework.stereotype.Component;

/**
 * @Date And @Time: 2022/1/13  21:15
 *
 * mybatis-plus  在满足的情况下 可以直接继承baseMapper  无需再编写mapper.xml文件
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
