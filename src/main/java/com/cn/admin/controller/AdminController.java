/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cn.admin.service.AdminService;

/**
 *
 * @author JessionZhang
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired AdminService aService;
    
    @RequestMapping("/index")
    public String index(String username,String password)
    {
        if(!"".equals(username) && !"".equals(password))
        {            
            boolean result=aService.login(username, password);
            if(result)
            {
                return "admin/manger";
            }else{
                return "admin/index";
            }
            
        }else{
            return "admin/index";
        }
        
    }
    
    
}
