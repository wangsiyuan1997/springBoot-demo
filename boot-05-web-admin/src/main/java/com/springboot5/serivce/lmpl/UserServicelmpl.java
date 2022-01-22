package com.springboot5.serivce.lmpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot5.bean.User;
import com.springboot5.mapper.UserMapper;
import com.springboot5.serivce.UserService;
import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/13  21:42
 */
@Service
public class UserServicelmpl extends ServiceImpl<UserMapper, User> implements UserService  {

}
