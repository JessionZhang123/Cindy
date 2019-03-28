/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cn.dao;

import com.cn.bean.AdminBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author JessionZhang
 */
public interface AdminDao {
    
    @Select("select id from admin where username=#{username} and password=#{password} and status=1")
    AdminBean login(@Param("username") String username,@Param("password") String password);
    
}
