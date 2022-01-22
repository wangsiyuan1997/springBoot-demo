package com.springboot5.mapper;

import com.springboot5.bean.Tuser;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

/**
 * @Date And @Time: 2022/1/13  18:38
 */
@Mapper
public interface BookMapper {
    public Tuser queryById(Integer id);

}
