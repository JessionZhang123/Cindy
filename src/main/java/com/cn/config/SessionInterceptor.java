/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cn.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author JessionZhang
 */
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter
{

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception 
    {        
        if(hsr.getRequestURI().contains("login"))
        {
            return true;
        }
        Object object = hsr.getSession().getAttribute("userlogin");
        if(object==null)
        {
            hsr1.sendRedirect(hsr.getContextPath()+"/admin/login");
            return false;
        }else{
            return true;
        }
        
    }


    
}
