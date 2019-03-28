/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cn.admin.service.impl;

import com.cn.bean.AdminBean;
import com.cn.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.admin.service.AdminService;
import com.cn.util.Md5EncodeUtil;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author JessionZhang
 */
@Service
public class AdminServiceImpl implements AdminService
{

    @Autowired AdminDao adminDao;
    
    @Override
    public boolean login(String username, String password) 
    {
        boolean flag=false;
        if(!(StringUtils.isBlank(username) || StringUtils.isBlank(password)))
        {
            password=Md5EncodeUtil.MD5Encode(password, "utf-8");
            AdminBean result= adminDao.login(username, password); 
            if(result!=null && result.getId()!=0) flag=true;            
        }
        return flag;
    }
    
}
