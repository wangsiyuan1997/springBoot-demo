package com.springboot5.admin;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot5.bean.User;
import com.springboot5.mapper.UserMapper;
import com.springboot5.serivce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate template;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate redisTemplate ;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void contextLoads() {
        Long aLong = template.queryForObject("select count(*) from t_book", long.class);
        System.out.println(aLong);

        log.info("dataSource的类型是{}",dataSource.getClass());
    }

    @Test
    void test1(){
//        User user = userService.selectById(1L);
//        log.info("User表的数据是{}",user);
    }

    @Test
    void test2(){
        for (int i = 7; i <1000 ; i++) {
            String s = UUID.randomUUID().toString();
            String substring = s.substring(1,8);
            long l = new BigDecimal(i).longValue();
//            System.out.println(substring);
//            System.out.println(l);
            userService.save(new User(null,null,l,substring,19,"44444@qq.com"));
        }
    }

    @Test
    public void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }

}
