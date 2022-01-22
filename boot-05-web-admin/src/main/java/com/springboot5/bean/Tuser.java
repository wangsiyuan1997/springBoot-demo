package com.springboot5.bean;

import lombok.Data;

import java.sql.SQLTransactionRollbackException;

/**
 * @Date And @Time: 2022/1/13  18:39
 */
@Data
public class Tuser {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
