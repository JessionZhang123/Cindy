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
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author JessionZhang
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Resource
    private AdminService aService;
    
    @RequestMapping("/index")
    public String index(HttpSession session)
    {
        String login=(String)session.getAttribute("userlogin");
        if("".equals(login)||login==null)
        {
            return "redirect:login";
        }else{
            return "admin/manger";  
        }
        
    }
    
    @RequestMapping("/login")
    public String login (HttpServletRequest request,HttpSession session)
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return "admin/login";
        }else{
            boolean result=aService.login(username, password);
            if(result)
            {
                session.setAttribute("userlogin", username);
                return "redirect:index";
            }else{
                return "admin/login";
            }
        }
    }
    
    
}
