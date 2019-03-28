/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author JessionZhang
 */
@SpringBootApplication
@MapperScan("com.cn.dao")
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
