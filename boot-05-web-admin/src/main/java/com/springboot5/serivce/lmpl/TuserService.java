package com.springboot5.serivce.lmpl;

import com.springboot5.bean.Tuser;
import com.springboot5.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/13  18:56
 */
@Service
public class TuserService {
    @Autowired
    BookMapper bookMapper;

 public Tuser queryById(Integer id){
        Tuser tuser = bookMapper.queryById(id);
        return tuser;
    }
}
